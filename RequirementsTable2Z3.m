function [] = RequirementsTable2Z3(modelpath)
%RequirementsTable2Z3 Converts the Requirements Tables contained in the
%filw with path path into Z3
%   modelpath: the path of the file to be considered. for Example, to run
%   the scripts of the file ''ProjectExamples/MioProgetto.slx'' run
%   RequirementsTable2Z3("ProjectExamples/MioProgetto.slx")
    
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
        disp(strcat("Requirements table: ",requirementsTable.Name))

        % gets the requirement rows from the specified table
        rrow=getRequirementRows(requirementsTable);
       
        for requirementIterator=1:size(rrow,2)

            requirement=rrow(requirementIterator);
            disp(strcat("Requirement: ",requirement.Index))
            disp(strcat("Precondition: ",rrow(requirementIterator).Preconditions))
            disp(strcat("Postcondition: ",rrow(requirementIterator).Postconditions))
        end
    end
end















