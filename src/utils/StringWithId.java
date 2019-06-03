package utils;

import static utils.Constants.UNDERLINE;

// stream2/task16_SortStringByPrefix
final public class StringWithId {
    public final int iD;
    public final String sourceStr;

    public StringWithId(int iD, String sourceStr) {
        this.iD = iD;
        this.sourceStr = sourceStr;
    }

    public StringWithId (String str) {
        //int id = Integer.parseInt(str.substring(str.lastIndexOf(UNDERLINE)+1));
        this.iD = parseId(str);
        this.sourceStr = str;
    }

    public static int parseId(String str) {
        return Integer.parseInt(str.substring(str.lastIndexOf(UNDERLINE)+1));
    }


    public int hashCode() {
        final int prime =31;
        int result = 1;
        result = prime * result +
                ((Integer.valueOf(iD) == null) ? 0 : Integer.valueOf(iD).hashCode());
        return result;
    }

    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final StringWithId other = (StringWithId) obj;
        if (Integer.valueOf(iD) == null) {
            if (Integer.valueOf(other.iD) != null)
                return false;
        } else if (iD != other.iD)
            return false;
        return true;
    }
}
