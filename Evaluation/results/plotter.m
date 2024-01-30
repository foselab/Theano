function [] = plotter(Table,filter,table,check,index)

    
    rf=rowfilter(Table);
    FilteredTable=Table(rf.encoding==filter & rf.table==table & rf.check==check,:);

    Time=FilteredTable(:,"time");
    timeValues=Time{:,1};
    Bound=FilteredTable(:,"bound");
    boundValues=Bound{:,1};


    [sortBoundValues, sortidx] = sort(boundValues);
    sortTimeValues = timeValues(sortidx);
    plot(sortBoundValues,sortTimeValues,'-o');
    hold on;
    grid on;

    %disp(strcat("mean: ", num2str(mean(timeValues)),"      max: ", num2str(max(timeValues)), "      min: ", num2str(min(timeValues)), "      std: ", num2str(std(timeValues))));
   % title(strcat(table,": ",FilteredTable{1,7}{1}))
    ylabel('Time [s]');
    xlabel('Threshold');
    set(gcf, 'Color', 'white');


end