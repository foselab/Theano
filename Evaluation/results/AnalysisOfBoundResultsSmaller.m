clear
close all;

check="consistency";
filePath='boundedResults_consistency_smaller.csv';
averageTablePath='.boundedResults_consistency_smaller.csv';
Table = readtable(filePath); 

filters=["BeArFs" "BeArVs" "BeUfFs" "BeUfVs"];
tables=["Table1" "Table2" "Table3" "Table4"];


checkStatistics(Table,check,tables,filters);



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
              %disp(strcat("bound   ",num2str(bound)));
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
              if ~isnan(mean(timerequired))
                disp(strcat("bound: ", num2str(bound), "  mean: ", num2str(mean(timerequired)), "      min: ", num2str(min(timerequired)), "      max: ", num2str(max(timerequired)),"      std: ", num2str(std(timerequired))));
              end
              res=[res count/size(result,1)*100];
          end
          disp(strcat(table, ":  ", mat2str(res), '%'));
      end
    end
    disp(strcat("Total time: ", num2str(time)));
end