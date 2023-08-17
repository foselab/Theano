function [] = requirementsTable2text(modelname, modelpath, destinationFolder)
%RequirementsTable2Z3 It takes  a simulink model as input, extracts the Requirements Tables, and generates a text file for each Requirement Table.
% The generated text files are .txt files named with the name of the
% corresponding Requirements Table.
% 
% Inputs:
%   modelpath: the path of the file to be considered. For Example, to run
%   the scripts of the file ''ProjectExamples/MioProgetto.slx'' run
%   requirementsTable2text("ProjectExamples/MioProgetto.slx")
%   requirementsTable2text("Example1.slx","ProjectExamples/","ProjectExamples/")
%
%   destinationFolder: the path of the folder in which the .txt files need
%   to be saved.

    %If the destination folder parameter is not provided creates an empty string.
    if exist('destinationFolder','var') == 0
        destinationFolder='';
    end

    %If the modelpath folder parameter is not provided creates an empty string.
    if exist('modelpath','var') == 0
        modelpath='';
    end

    modelnameNoExtension=erase(modelname,'.slx');

    disp('---------------------------------------------------');
    disp(strcat("opening the model: ", modelpath))
    % Open the project in simulink
    open(strcat(modelpath,modelname))
   
    % Looks up the requirements associated with the current Simulink model and returns the results in a table
    reqTables=slreq.modeling.find(gcs);
    
    % Analyzes each requirements table in the list of requirements tables
    for req_tablesIterator = 1:size(reqTables,2)

        % gets the current requirements table to be analyzed
        requirementsTable=reqTables(req_tablesIterator);
        
        % displays the name of the requirements table
        
        disp('---------------------------------------------------');
        disp(strcat("Analyzing the Requirements Table: ",requirementsTable.Name))


        disp(strcat("Writing the file ",requirementsTable.Name,".txt for the Requirements Table: ",requirementsTable.Name));

       
         fid = fopen(strcat(destinationFolder,requirementsTable.Name,'.txt'),'wt');

         tableHandle=strcat(modelnameNoExtension,'/',requirementsTable.Name);
        table=slreq.modeling.find(tableHandle);

        % gets the inports
        fprintf(fid, '------- Input Data -----\n');
        data = findSymbol(table,Scope="Input"); 

        for dataIterator = 1:size(data,2)
            disp(data(dataIterator).Name)
            disp(data(dataIterator).Type)

            tp='null';
            if contains(data(dataIterator).Type,'int')
                tp='Int';
            end
            if data(dataIterator).Type=="double" || data(dataIterator).Type=="single" || data(dataIterator).Type=="half"
                tp='Real';
            end
            if data(dataIterator).Type=="boolean"
                tp='Bool';
            end
            if(tp=='null')
                error(strcat("You must specify the type of the variable '",data(dataIterator).Name ,"' of the Requirements Table '" ,requirementsTable.Name,"'"));
            end
            fprintf(fid, strcat(data(dataIterator).Name,',',tp,'\n'));
        end


        % gets the requirement rows from the specified table
        rrow=getRequirementRows(requirementsTable);
       

        fprintf(fid, '------- Requirements -----\n');
        for requirementIterator=1:size(rrow,2)

            requirement=rrow(requirementIterator);
            disp(strcat("Requirement: ",requirement.Index))
            disp(strcat("Precondition: ",rrow(requirementIterator).Preconditions))
            fprintf(fid, rrow(requirementIterator).Preconditions{1});
            fprintf(fid,'\n');
            disp(strcat("Postcondition: ",rrow(requirementIterator).Postconditions))
            fprintf(fid, rrow(requirementIterator).Postconditions{1});
            fprintf(fid,'\n');
            %fprintf(fid, '\n');
        end
        fclose(fid);
    end
    
end

















