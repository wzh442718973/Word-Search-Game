package com.refined.stylish.sanhdieu.data.xml;

import android.content.Context;
import android.content.res.AssetManager;

import com.refined.stylish.sanhdieu.R;
import com.refined.stylish.sanhdieu.domain.data.source.WordDataSource;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.IOException;

import javax.inject.Inject;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by abdularis on 31/07/17.
 */

public class WordXmlDataSource implements WordDataSource {

    private final Context mContext;

    @Inject
    public WordXmlDataSource(Context context) {
        mContext = context;
    }

    @Override
    public void getWords(Callback callback) {
        try {
            XMLReader reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            SaxWordBankHandler wordBankHandler = new SaxWordBankHandler();
            reader.setContentHandler(wordBankHandler);
            reader.parse(getXmlInputSource());

            // return result
            callback.onWordsLoaded(wordBankHandler.getWords());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private InputSource getXmlInputSource() throws IOException {
        return new InputSource(mContext.getResources().openRawResource(R.raw.words));
        //mAssetManager.open("words.xml"));
    }
}
