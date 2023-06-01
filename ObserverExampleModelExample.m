%% Observe Model Behavior
% You can use the Requirements Table block to observe the model behavior
% without executing actions. If the model behavior does not satisfy a
% precondition, the block does not check the associated postcondition. If
% the model behavior does not satisfy the postcondition for a requirement
% when the precondition is satisfied, the Requirements Table block produces
% a warning in the Diagnostic Viewer. To use the Requirements Table block
% to observe requirements, use the preconditions to specify model input
% behavior, and use the postconditions to specify model output behavior. To
% differentiate between the model inputs and outputs, enable the *Treat as
% design model output for analysis* property in the Property Inspector for
% the data specified in the postconditions.
%
% This model contains a Requirements Table block that tests a basic
% subsystem that has two inputs and outputs two values. The Requirements
% Table block checks whether the inputs and outputs of the subsystem meet
% the specified requirements by using logical definitions for the
% preconditions and postconditions.

% Copyright 2021 The MathWorks, Inc.

%%
model = 'Observer_mode_model';
open_system(model);

%%
% Open the Requirements Table block to see the requirements specified
% for the inputs and outputs of the subsystem. The requirements specify
% logical constraints on the subsystem outputs for each subsystem input.
% The Requirements Table block captures the subsystem inputs with the
% data |u1| and |u2|, and captures the subsystem outputs with the
% data |y1| and |y2|. The block defines the data as input data,
% which allows the block to capture the subsystem signals as block
% inputs.
%
% <<../ReqTable_Observer_example.png>>
% 

%%
% When you run the model, the Requirements Table block checks if the
% Subsystem block inputs satisfy the preconditions. If the preconditions
% are met, the Requirements Table block checks if the Subsystem block
% outputs satisfy the postconditions.
%
% This example Subsystem block satisfies the preconditions and
% postconditions. To generate a warning, set the postcondition of the first
% requirement to |y1 < 0| and run the simulation again. The *Diagnostic
% Viewer* displays a warning message.
%
% <<../ReqTable_Observer_example_warning.png>>
%
