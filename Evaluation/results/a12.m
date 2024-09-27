
%% Define Vargha-Delaney test function
function a = a12(x, y)

[~,~,s] = ranksum(x,y);

m = size(x,1);
n = size(y,1);

a = (s.ranksum/m - (m+1)/2)/n;

end


