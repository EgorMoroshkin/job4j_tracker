package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport reportText = new TextReport();
        HtmlReport reportHtml = new HtmlReport();
        JSONReport reportJson = new JSONReport();
        String text = reportText.generate("Report's name", "Report's body");
        System.out.println(text);
        System.out.println();
        String html = reportHtml.generate("Report's name", "Report's body");
        System.out.println(html);
        System.out.println();
        String json = reportJson.generate("Report's name", "Report's body");
        System.out.println(json);

    }
}
