package com.fooock.digital.ocean;

import java.io.*;

/**
 *
 */
public final class ReadResources {

    public String loadJson(String name) {
        try {
            final File file = new File(name);
            final InputStream is = new FileInputStream(file);
            final BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            final StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            is.close();
            reader.close();
            return sb.toString();
        } catch (IOException ex) {
            return "";
        }
    }
}
