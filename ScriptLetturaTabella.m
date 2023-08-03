% Open the project in simulink
open_system('MioProgetto.slx')


% Give the name "model" to my projec
model='MioProgetto.slx';


% Loads the requirement set and the link set into memory
[myLinkSet,myReqSet] = slreq.load(model);


% Properties 
requirements=find(myReqSet,"Type","Requirement");


% Looks up the requirements associated with the current Simulink model and returns the results in a table
table=slreq.modeling.find(gcs);


% Requirement rows from the specified table
rrow=getRequirementRows(table);


% Access to the "Postconditions" attribute of the first requirement in the requirements table
rrow(1).Postconditions


% Access to the "Preconditions" attribute of the first requirement in the requirements table
rrow(1).Preconditions


% Adding data to an empty requirement
rrow(2).Postconditions = {'y2 > 5'};


% Specify the number of lines
row = 2


% For loop for precondition
for i = 1:row
    rrow(i).Preconditions
end


% For loop for postcondition
for i = 1:row
    rrow(i).Postconditions
end















