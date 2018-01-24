package pers.hanchao.showpdf;

/**
 * Created by 韩超 on 2018/1/17.
 */
public class PdfUtils {
    private String name;

    public PdfUtils(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PdfUtils{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args){
        PdfUtils pdfUtils = new PdfUtils("hhhh");
        System.out.println(pdfUtils.toString());
    }
}
