package com.example.couple.Model.BridgeSingle;

import com.example.couple.Base.Handler.NumberBase;
import com.example.couple.Model.Support.JackpotHistory;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ClawBridge {
    List<Integer> touchs;
    int bridgeType;
    JackpotHistory jackpotHistory;


    public boolean isWin() {
        return NumberBase.isTouch(jackpotHistory, touchs);
    }

    public String showBridge() {
        String show = "";
        String win = jackpotHistory.isEmpty() ? "" : (isWin() ? "trúng" : "trượt");
        show += " * " + jackpotHistory.show() + " - " + win + "\n";
        show += "    - Cầu liên thông: " + showTouchs() + ".";
        return show;
    }

    public String showTouchs() {
        return NumberBase.showTouchs(touchs);
    }

    public static ClawBridge getEmpty() {
        return new ClawBridge(new ArrayList<>(), 0, JackpotHistory.getEmpty());
    }
}
