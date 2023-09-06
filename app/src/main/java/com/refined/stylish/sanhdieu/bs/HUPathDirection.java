package com.refined.stylish.sanhdieu.bs;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class HUPathDirection {
private double selectorPrefsMax = 0.0;
private int interface_aAnswerRandomFlag = 0;
double presenterGraphicsMin = 0.0;


    private final File mFile;
    private boolean bLock;
    private final LinkedList<PDMatchLayout> mLinked = new LinkedList<>();
    private final Set<PDMatchLayout> mAll = new HashSet<>();

    public enum HNWArrays {
        ADD,
        REMOVE,
        REPLACE,
    }

    private static class PDMatchLayout {
private float createNormalizeMin = 0.0f;
private float default__ePackage_space = 0.0f;



        public HNWArrays mOpt;
        public int nNumber;
        public String mSource;
        public String mTarget;

        public PDMatchLayout(HNWArrays opt, int line, String content) {
            this.mOpt = opt;
            this.nNumber = line;
            this.mTarget = content;
        }

        public PDMatchLayout(HNWArrays opt, int line, String source, String target) {
            this.mOpt = opt;
            this.nNumber = line;
            this.mSource = source;
            this.mTarget = target;
        }
    }

    public HUPathDirection(String file) {
        this(new File(file));
    }

    public HUPathDirection(File file) {
        this.mFile = file;
    }

    public HUPathDirection add(String content) {
        checkLock();
        mLinked.add(new PDMatchLayout(HNWArrays.ADD, Integer.MAX_VALUE, content));
        return this;
    }

    public HUPathDirection set(int line, String content) {
        checkLock();
        if (line < 0) {
            line = Integer.MAX_VALUE;
        }
        mLinked.add(new PDMatchLayout(HNWArrays.ADD, line, content));
        return this;
    }

    public HUPathDirection remove(int line) {
        checkLock();
        mLinked.add(new PDMatchLayout(HNWArrays.REMOVE, line, null));
        return this;
    }

    public HUPathDirection replace(int line, String content) {
        checkLock();
        mLinked.add(new PDMatchLayout(HNWArrays.REPLACE, line, content));
        return this;
    }

    public HUPathDirection replace(String source, String target) {
        checkLock();
        mAll.add(new PDMatchLayout(HNWArrays.REPLACE, -1, source, target));
        return this;
    }

    private void checkLock() {
        if (bLock) {
            throw new RuntimeException(new IOException("file is opt!"));
        }
    }

    private void sortElement() {
        Collections.sort(mLinked, new Comparator<PDMatchLayout>() {
            @Override
            public int compare(PDMatchLayout element, PDMatchLayout t1) {
                return element.nNumber - t1.nNumber;
            }
        });
    }

    private static final String CRLN = "\n";

     
    private static int processText(Writer writer, int line, String text, PDMatchLayout element) throws IOException {
        if (element != null) {
            if (text == null) {
                if (element.mOpt == HNWArrays.ADD) {
                    if (element.nNumber == Integer.MAX_VALUE || line == element.nNumber) {
                        writer.write(element.mTarget);
                        writer.write(CRLN);
                    } else {
                        writer.write(CRLN);
                        return 1;
                    }
                }
            } else if (line < element.nNumber) {
                
                writer.write(text);
                writer.write(CRLN);
                return 1;
            } else if (line > element.nNumber) {
                
                System.out.println("-------------------------!");
            } else {
                if (element.mOpt == HNWArrays.ADD) {
                    writer.write(element.mTarget);
                    writer.write(CRLN);
                    return 2;
                } else if (element.mOpt == HNWArrays.REMOVE) {

                } else if (element.mOpt == HNWArrays.REPLACE) {
                    writer.write(element.mTarget);
                    writer.write(CRLN);
                } else {

                }
            }
        } else {
            if (text != null) {
                writer.write(text);
                writer.write(CRLN);
            }
            return 1;
        }
        return 3;
    }

    public synchronized void build() throws Exception {
        checkLock();
        bLock = true;

        final Charset def = EPHInterface.getCharset();

        final File tmpFile = new File(mFile.getAbsoluteFile() + ".tmp");
        BufferedReader reader = null;
        BufferedWriter writer = null;
        sortElement();
        boolean sucess = false;
        try {
            if (mFile.exists()) {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(mFile), def));
            } else {
                reader = new BufferedReader(new StringReader(""));
            }
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tmpFile), def));


            String sLine = null;
            PDMatchLayout element = null;

            int next = 3;
            int nLine = -1;
            do {
                if ((next & 1) != 0) {
                    sLine = reader.readLine();
                    ++nLine;

                    if (sLine != null) {
                        for (PDMatchLayout el : mAll) {
                            sLine = sLine.replace(el.mSource, el.mTarget);
                        }
                    }
                }
                if ((next & 2) != 0) {
                    element = mLinked.poll();
                }
                next = processText(writer, nLine, sLine, element);
            } while (sLine != null || element != null);

            sucess = true;
        } finally {
            bLock = false;
            GXLibmplame.Close(reader);
            GXLibmplame.Close(writer);

            if (sucess) {
                final File bakFile = new File(mFile.getParentFile(), "." + mFile.getName());
                if (mFile.exists()) {
                    mFile.renameTo(bakFile);
                }
                if (tmpFile.renameTo(mFile)) {
                    bakFile.delete();
                } else {
                    throw new IOException("file opt error!");
                }
            }

        }
    }
}
