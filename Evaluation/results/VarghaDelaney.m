Y_Temp=[];
X_Temp=[];

fid = fopen('boundedResults_consistency.csv');
tline = fgetl(fid);
while ischar(tline)
   splitted = strsplit(tline,',');
   if contains(splitted{1,3},'Ar')
         Y_Temp=[Y_Temp  str2num(splitted{1,8})];
   else
         X_Temp=[X_Temp  str2num(splitted{1,8})];
   end
   tline = fgetl(fid);
end
fclose(fid);



% Vargha-Delaney test
    a_Temp = a12(X_Temp,Y_Temp);
    if a_Temp >= 0.71
        fprintf('The Vargha-Delaney test returns big evidence of stochastic superiority of %s compared to %s: A_12 = %.2f.\n','Ar', 'Uf', a_Temp)
    elseif a_Temp >= 0.64
        fprintf('The Vargha-Delaney test returns medium evidence of stochastic superiority of %s compared to %s: A_12 = %.2f.\n','Ar', 'Uf',a_Temp)
    elseif a_Temp >= 0.56
        fprintf('The Vargha-Delaney test returns small evidence of stochastic superiority of %s compared to %s: A_12 = %.2f.\n','Ar', 'Uf',a_Temp)
    else
        fprintf('The Vargha-Delaney test cannot confirm the stochastic superiority of %s compared to %s: A_12 = %.2f.\n','Ar', 'Uf',a_Temp)
    end