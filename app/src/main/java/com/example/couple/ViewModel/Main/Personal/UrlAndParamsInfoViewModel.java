package com.example.couple.ViewModel.Main.Personal;

import android.content.Context;

import com.example.couple.Base.Handler.IOFileBase;
import com.example.couple.View.Main.Personal.UrlAndParamsInfoView;

public class UrlAndParamsInfoViewModel {
    UrlAndParamsInfoView view;
    Context context;
    String data = "";
    String fileName = "";

    public UrlAndParamsInfoViewModel(UrlAndParamsInfoView view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void GetUrlAndParams(String type) {
        if (type.equals("jackpot")) {
            fileName = "urljackpot.txt";
        } else if (type.equals("lottery")) {
            fileName = "urllottery.txt";
        }
        data = IOFileBase.readDataFromFile(context, fileName);
        String arr[] = data.split("\n");
        view.ShowUrlAndParams(arr);
    }

    public void SaveData(String url, String className) {
        String data2 = url + "\n" + className;
        if (url.equals("") || className.equals("")) {
            view.ShowError("Vui lòng nhập url và Class Name!");
        } else if (data2.equals(data)) {
            view.SaveDataSuccess(0);
        } else {
            IOFileBase.saveDataToFile(context, fileName, data2, 0);
            view.SaveDataSuccess(1);
        }
    }
}
