package com.refined.stylish.sanhdieu.data.xml;
import java.util.Random;


import java.util.HashMap;



import com.refined.stylish.sanhdieu.domain.model.IInit;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

 

class JRSPack extends DefaultHandler {
long mapperReverse_sum = 0;
boolean isWindow_uLoadExit = false;
private boolean has_TitleDirection = false;
private HashMap<String,Float> itemLoading_map;




    private static final String XML_ITEM_TAG_NAME = "item";
    private static final String XML_STR_ATTRIB_NAME = "str";

    private List<IInit> mWordList;

    @Override
    public void startDocument() throws SAXException {
        mWordList = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase(XML_ITEM_TAG_NAME)) {
            IInit word = new IInit(mWordList.size(), attributes.getValue(XML_STR_ATTRIB_NAME));
            mWordList.add(word);
        }
    }

    List<IInit> getWords() {
        return mWordList;
    }
}
