package com.example.couple.Model.Time.Cycle;

import com.example.couple.Custom.Const.Const;
import com.example.couple.Custom.Const.TimeInfo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * class earthly branches
 */

@Getter
public class Branches {
    int position;
    String name;

    public Branches(int position) {
        this.position = position == Const.EMPTY_VALUE ? position : position % 12;
        this.name = position == Const.EMPTY_VALUE ? "" : TimeInfo.EARTHLY_BRANCHES.get(position % 12);
    }

    public List<Branches> getCompatibleBranches() {
        List<Branches> results = new ArrayList<>();
        for (int i = 4; i < 12; i += 4) {
            int new_position = (position + i) % 12;
            Branches branches = new Branches(new_position);
            results.add(branches);
        }
        return results;
    }

    public List<Branches> getIncompatibleBranches() {
        List<Branches> results = new ArrayList<>();
        for (int i = 3; i < 12; i += 3) {
            int new_position = (position + i) % 12;
            Branches branches = new Branches(new_position);
            results.add(branches);
        }
        return results;
    }

    public String showCompatibleBranches() {
        List<Branches> compatibles = getCompatibleBranches();
        String show = "";
        for (Branches branches : compatibles) {
            show += branches.getPosition() % 10 + " ";
        }
        return show.trim();
    }

    public String showIncompatibleBranches() {
        List<Branches> incompatibles = getIncompatibleBranches();
        String show = "";
        for (Branches branches : incompatibles) {
            show += branches.getPosition() % 10 + " ";
        }
        return show.trim();
    }

    public String show() {
        return name + " (" + position + ")";
    }

    public static Branches getEmpty() {
        return new Branches(Const.EMPTY_VALUE);
    }

    public boolean isEmpty() {
        return position == Const.EMPTY_VALUE || name.equals("");
    }
}
