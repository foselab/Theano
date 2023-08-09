function [] = RequirementsTable2Z3(modelpath,destinationFile)
%RequirementsTable2Z3 Converts the Requirements Tables contained in the
%file into a textual format within the file destinationFile
% Inputs:
%   modelpath the path of the file to be considered. for Example, to run
%   the scripts of the file ''ProjectExamples/MioProgetto.slx'' run
%   RequirementsTable2Z3("ProjectExamples/MioProgetto.slx")
    
    disp(strcat("opening the model: ", modelpath))
    % Open the project in simulink
    open(modelpath)
    fid = fopen(destinationFile,'wt');
    
    % Looks up the requirements associated with the current Simulink model and returns the results in a table
    reqTables=slreq.modeling.find(gcs);
    
    % Analyzes each requirements table in the list of requirements tables
    for req_tablesIterator = 1:size(reqTables,2)

        % gets the current requirements table to be analyzed
        requirementsTable=reqTables(req_tablesIterator);

        % displays the name of the requirements table
        disp(strcat("Requirements table: ",requirementsTable.Name))

        % gets the requirement rows from the specified table
        rrow=getRequirementRows(requirementsTable);
       
        for requirementIterator=1:size(rrow,2)

            requirement=rrow(requirementIterator);
            disp(strcat("Requirement: ",requirement.Index))
            fprintf(fid, requirement.Index);
            disp(strcat("Precondition: ",rrow(requirementIterator).Preconditions))
            fprintf(fid, rrow(requirementIterator).Preconditions{1});
            disp(strcat("Postcondition: ",rrow(requirementIterator).Postconditions))
            %fprintf(fid, rrow(requirementIterator).Postconditions{1});
            %fprintf(fid, '\n');
        end
    end
    fclose(fid);
end

















