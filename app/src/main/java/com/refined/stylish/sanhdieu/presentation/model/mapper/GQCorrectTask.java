
package com.refined.stylish.sanhdieu.presentation.model.mapper;
import android.widget.TextView;


import android.widget.ImageView;


import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import com.refined.stylish.sanhdieu.commons.ZBFusion;
import com.refined.stylish.sanhdieu.domain.model.TFCaseField;
import com.refined.stylish.sanhdieu.presentation.custom.ASanboxView;

 

public class GQCorrectTask extends ZBFusion<TFCaseField.GEBilling, ASanboxView.CULogo> {
    @Override
    public ASanboxView.CULogo map(TFCaseField.GEBilling obj) {
        ASanboxView.CULogo s = new ASanboxView.CULogo();
        s.getStartIndex().set(obj.startRow, obj.startCol);
        s.getEndIndex().set(obj.endRow, obj.endCol);
        s.setColor(obj.color);

        return s;
    }

    @Override
    public TFCaseField.GEBilling revMap(ASanboxView.CULogo obj) {
        TFCaseField.GEBilling a = new TFCaseField.GEBilling();
        a.startRow = obj.getStartIndex().row;
        a.startCol = obj.getStartIndex().col;
        a.endRow = obj.getEndIndex().row;
        a.endCol = obj.getEndIndex().col;
        a.color = obj.getColor();

        return a;
    }
}
