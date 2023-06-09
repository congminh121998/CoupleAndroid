package com.example.couple.ViewModel.Sub;

import android.content.Context;

import com.example.couple.Base.Handler.IOFileBase;
import com.example.couple.Custom.Const.Const;
import com.example.couple.View.Sub.NoteInfoView;

public class NoteInfoViewModel {
    NoteInfoView noteInfoView;
    Context context;

    public NoteInfoViewModel(NoteInfoView noteInfoView, Context context) {
        this.noteInfoView = noteInfoView;
        this.context = context;
    }

    public void AddNote(String note) {
        IOFileBase.saveDataToFile(context, Const.NOTE_FILE_NAME, note + "===", 1);
        noteInfoView.AddNoteSuccess("Thêm ghi chú thành công!");
    }
}
