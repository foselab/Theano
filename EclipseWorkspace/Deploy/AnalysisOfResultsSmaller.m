clear
close all;

%checks=["completeness"];
%filePath='results/boundedResults_.csv';
%averageTablePath='results/resultsAverage.csv';

checks=["consistency"];
filePath='results/boundedResults_smaller.csv';
averageTablePath='results/resultsAverage_smaller_consistency.csv';

Table = readtable(filePath); 

%filters=["UeArFs" "UeArVs" "UeUfFs" "UeUfVs" "BeArFs" "BeArVs" "BeUfFs" "BeUfVs"];
filters=["BeArFs" "BeArVs" "BeUfFs" "BeUfVs"];
tables=["Table1" "Table2" "Table3" "Table4"];
c=["consistency" "completeness"];
%checks=["consistency" "completeness"];


checkStatistics(Table,checks,tables,filters);

computingAverage=1;

if computingAverage==1
    computeAverageTable(filePath,averageTablePath);
end

AverageTable = readtable(averageTablePath); 


disp('--------------------------')
disp('Generic statistics')


disp(strcat("*****Completeness ", check, "*****"));
for filter = filters
    rf=rowfilter(Table);
    FilteredTable2=Table(rf.check==check & rf.encoding==filter & rf.result=="Complete" & rf.expectedResult=="Complete", :);
    Time1=FilteredTable2(:,"time");
    timeValues1=Time1{:,1};

    FilteredTable3=Table(rf.check==check & rf.encoding==filter & rf.result=="Incomplete" & rf.expectedResult=="Incomplete", :);
    Time2=FilteredTable3(:,"time");
    timeValues2=Time2{:,1};
    timeValues=[timeValues1; timeValues2];
    disp(strcat("check: ", check, "   encoding: ", filter, "       mean: ", num2str(mean(timeValues)), "      min: ", num2str(min(timeValues)), "      max: ", num2str(max(timeValues)),"      std: ", num2str(std(timeValues))));
end


disp(strcat("*****Consistency ", check, "*****"));
for filter = filters
    rf=rowfilter(Table);
    FilteredTable3=Table(rf.check==check & rf.encoding==filter & rf.result=="Inconsistent" & rf.expectedResult=="Inconsistent", :);
    Time2=FilteredTable3(:,"time");
    timeValues2=Time2{:,1};
    timeValues=[timeValues2];
    disp(strcat("check: ", check, "   encoding: ", filter, "       mean: ", num2str(mean(timeValues)), "      min: ", num2str(min(timeValues)), "      max: ", num2str(max(timeValues)),"      std: ", num2str(std(timeValues))));
end


function [] = checkStatistics(Table,checks,tables,filters)

   disp(strcat("bounds: ",mat2str(unique(Table.bound'))));
    time=0;  
    for table = tables
      res=[];
      nruns=[];

      if strcmp(table,"Table3")==1 ||  strcmp(table,"Table4")==1
          disp(table);
          for bound = unique(Table.bound)'
              timerequired=[];
              disp(strcat("bound   ",num2str(bound)));
              count=0;
              filterfinalcount=0;
              filterfinalcorrect=0;
             
              for check =checks
                   rf=rowfilter(Table);
                    FilteredTable=Table(rf.table==table & rf.check==check & rf.bound==bound,:);
            
                    Result=FilteredTable(:,"result");
                    result=Result{:,1};
                    ExpectedResult=FilteredTable(:,"expectedResult");
                    expectedResult=ExpectedResult{:,1};
                
                    
                    for i=1:1:size(result,1)
                        filterfinalcount=filterfinalcount+1;
                        time=time+FilteredTable{i,8};
                        if(strcmp(result{i,1},expectedResult{i,1})==1)
                            count=count+1;
                            
                            filterfinalcorrect=filterfinalcorrect+1;
                            timerequired=[timerequired FilteredTable{i,8}];
                        else
                            if(strcmp(result{i,1},"Unknown")~=1)
                                disp(strcat("error!!!: table: ", table,"  check: ",check, "  encoding: ", filter, " inputFile: ", FilteredTable{i,"inputfile"}, " Result: ", result{i,1}, " Expected Result: ",expectedResult{i,1}));
                            else
                                %disp(strcat("difference!!!: table: ", table,"  check: ",check, "  encoding: ", filter, " inputFile: ", FilteredTable{i,"inputfile"}, " Result: ", result{i,1}, " Expected Result: ",expectedResult{i,1}));
                            end
                        end
                    end
              end
              disp(strcat("bound: ", num2str(bound), "  mean: ", num2str(mean(timerequired)), "      min: ", num2str(min(timerequired)), "      max: ", num2str(max(timerequired)),"      std: ", num2str(std(timerequired))));
              res=[res count/size(result,1)*100];
          end
          disp(strcat(table, ":  ", mat2str(res), '%'));
      end
    end
    disp(strcat("Total time: ", num2str(time)));
end

function [] = computeAverageTable(filePath,averageTablePath)
    disp("Computing the average results");
    faverageTable=fopen(averageTablePath,'w');
    fid = fopen(filePath, 'r');
    initline=fgetl(fid);
    fprintf(faverageTable,'%s\n',initline);
    tline = fgetl(fid);
    visited=[];
    counter=0;
    
    while ischar(tline)
       if(strcmp("",tline)==0)
           ret=split(tline,',',2);
           [tablePath, TableName, encoding, bound, check, result, expectedResult, time]=ret{:};
    
           if(strcmp(result,expectedResult)==1 && ~any(strcmp(visited,strcat(tablePath,encoding))))
               fid2 = fopen(filePath, 'r');
               tline2 = fgetl(fid2);
               tline2 = fgetl(fid2);
        
               numresults=0;
               timeresults=0;
               while ischar(tline2)
                 
                    if(fid2>fid && strcmp("",tline2)==0)
                        if(~any(strcmp(visited,strcat(tablePath,encoding))))
                            ret2=split(tline2,',',2);
                            [tablePath2, TableName2, encoding2, bound2, check2, result2, expectedResult2, time2]=ret2{:};
                            if(strcmp(result2,expectedResult2)==1 && strcmp(tablePath2,tablePath)==1  && strcmp(TableName2,TableName)==1 && strcmp(encoding2,encoding)==1 && strcmp(bound2,bound)==1 && strcmp(check2,check)==1)
                                numresults=numresults+1;
                                timeresults=timeresults+str2num(time2);
                            end
                        end
                    end
                    tline2 = fgetl(fid2);
               end
               visited = cat(2, visited, {strcat(tablePath,encoding)});
               avgtime=timeresults/numresults;
               fprintf(faverageTable,'%s,%s,%s,%s,%s,%s,%s,%f\n',tablePath, TableName, encoding, bound, check, result, expectedResult,avgtime);
           end
           counter=counter+1;
       end
        tline = fgetl(fid);
    end
    fclose(fid);
end