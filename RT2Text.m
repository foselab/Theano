function [] = RT2Text(modelpath)
%RequirementsTable2Z3 It takes  a simulink model as input, extracts the Requirements Tables, and generates a text file for each Requirement Table.
% The generated text files are .rt files named with the name of the
% corresponding Requirements Table.
% 
% Inputs:
%   modelpath: the path of the file to be considered. For Example, to run
%   the scripts of the file ''ProjectExamples/MioProgetto.slx'' run
%   requirementsTable2text("ProjectExamples/MioProgetto.slx")
%

    %If the destination folder parameter is not provided creates an empty string.
    if exist('destinationFolder','var') == 0
        destinationFolder='';
    end

    disp('---------------------------------------------------');
    disp(strcat("opening the model: ", modelpath))
    % Open the project in simulink
    open(modelpath)

    % Looks up the requirements associated with the current Simulink model and returns the results in a table
    reqTables=slreq.modeling.find(gcs);

    % Analyzes each requirements table in the list of requirements tables
    for req_tablesIterator = 1:size(reqTables,2)

        % gets the current requirements table to be analyzed
        requirementsTable=reqTables(req_tablesIterator);

        % displays the name of the requirements table

        disp('---------------------------------------------------');
        disp(strcat("Analyzing the Requirements Table: ",requirementsTable.Name))

        disp(strcat("Writing the file ",requirementsTable.Name,".rt for the Requirements Table: ",requirementsTable.Name));


        fid = fopen(strcat(destinationFolder,requirementsTable.Name,'.rt'),'wt');

        
        fprintf(fid, 'vardef\n');
        
        data=findSymbol(requirementsTable, 'Scope', 'Input');

        for n = 1 : length(data)
            symbol=data(n);
            type=symbol.Type;
            if (symbol.Type=='double')
                type='Real';
            end
            if symbol.IsDesignOutput==1 
                fprintf(fid, strcat('\t',symbol.Name,',',type,',output;\n'));
            else
                fprintf(fid, strcat('\t',symbol.Name,',',type,',input;\n'));
            end
        end
        fprintf(fid, 'endvardef\n');

        % gets the requirement rows from the specified table
        rrow=getRequirementRows(requirementsTable);

        fprintf(fid, 'reqdef\n');
        for requirementIterator=1:size(rrow,2)
            requirement=rrow(requirementIterator);
            fprintf(fid, strcat('\t',rrow(requirementIterator).Preconditions{1},',',rrow(requirementIterator).Postconditions{1},';\n'));
        end
        fprintf(fid, 'endreqdef\n');
        fclose(fid);
    end

end