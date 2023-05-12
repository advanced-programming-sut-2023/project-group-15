package org.example.view;

import org.example.InputScanner;
import org.example.controller.TradingMenuController;
import org.example.view.enums.commands.TradingMenuEnum;

import java.util.regex.Matcher;

public class TradingMenu {
        public void run()
        {
                TradingMenuController controller = new TradingMenuController();
                String tradeCommand;
                Matcher matcher ;
                while (true)
                {
                       /* tradeCommand = InputScanner.getScanner().nextLine();
                        if ((matcher = TradingMenuEnum.getMatcher(tradeCommand,TradingMenuEnum.TRADE)) != null)
                                controller.sendTradeRequest();
                        else if((matcher= TradingMenuEnum.getMatcher(tradeCommand , TradingMenuEnum.TRADE_ACCEPT)) != null)
                                controller.acceptRequest();
                        else if ((matcher = TradingMenuEnum.getMatcher(tradeCommand , TradingMenuEnum.TRADE_HISTORY)) != null)
                                controller.showTradeHistory();
                        else if ((matcher = TradingMenuEnum.getMatcher(tradeCommand , TradingMenuEnum.TRADE_LIST)) != null )
                                controller.showTradeList();*/

                }
        }
}
