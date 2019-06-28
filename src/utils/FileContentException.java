package utils;

public class FileContentException extends Exception {
    private String msg;

    public FileContentException(String msg) {
        this.msg=msg;
    }

    public FileContentException() {
        this.msg="";
    }

    @Override
    public String toString() {
        return "FileContentException: "+msg;
    }
}
