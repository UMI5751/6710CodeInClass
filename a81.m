clc, clear all, close all;

price = xlsread('C:\Users\haich\OneDrive\Programming\matlab\matlab_zhuo\data\Cha4_DataExplore\Section4_1\sz_data\sz000001.xls');

sr = size(price, 1);
cp = 30;
sampleValue = zeros((sr - cp), 10);
for h = 1 : (sr - cp)
    %dv1 = current day rise%? dv2 = 10days rise%
    dv1 = 100 * (price(h, 5) - price(h + 1, 5)) / price(h + 1, 5)
    dv2 = 100 * (price(h, 5) - price(h + 10, 5)) / price(h + 10, 5)
    %ADR
    riseNum = 0;
    decNum = 0;
    for i = 1 : 10;
        riseRate = 100 * (price(h + i - 1, 5) - price(h + i, 5)) / price(h + i, 5);
        if riseRate >= 0;
            riseNum = riseNum + 1;
        else
            decNum = decNum + 1;
        end;
    end
    %dv3 = adr, dv4 = rsi
    dv3 = riseNum / (decNum + 0.01)
    dv4 = riseNum / 10
    
    kvalue = zeros(1, 6);
    for i = 1 : 6
        kvalue(i) = (price(h + i - 1, 5) - price(h + i - 1, 2)) / (price(h + i - 1, 3) - price(h + i - 1, 4) + 0.01);
    end;
    dv5 = kvalue(1)
    dv6 = sum(kvalue(1, 1 : 6)) / 6
    %dv7 = 10 days bias
    dv7 = (price(h, 5) - sum(price(h : h + 9, 5)) / 10) / (sum(price(1 : h + 9, 5)) / 10)
    % dv8 = 9-day rsv
    % dv9 = 30-day rsv
    dv8 = (price(h, 5) - min(price(1 : h + 8, 5))) / (max(price(1 : h + 8, 5)) - min(price(1 : h + 8, 5)))
    dv9 = (price(h, 5) - min(price(1 : h + 29, 5))) / (max(price(1 : h + 29, 5)) - min(price(1 : h + 29, 5)))        
            
    %dv10 = obv
    dv10 = sign(price(h, 5) - price(h + 1, 5)) * price(h, 6) / (sum(price(h : h + 4, 6)) / 5)
    
    sampleValue(h, :) = [dv1, dv2, dv3, dv4, dv5, dv6, dv7, dv8, dv9, dv10];
end

sampleDate = price(1 : (sr - cp), 1);
outfile = 'C:\Users\haich\OneDrive\Programming\matlab\matlab_zhuo\data_generated\a82.xlsx'
xlswrite(outfile, sampleDate, 'Sheet1', ['A1:A' num2str(sr - cp) ]);
xlswrite(outfile, sampleValue, 'Sheet1', ['B1:K' num2str(sr - cp) ]);
            


            
            
            