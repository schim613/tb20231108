package com.ll.global.app;

import java.util.Scanner;

public class App {

    private final Scanner scanner;

    public App(final Scanner scanner) {
        this.scanner = scanner;
    }

    void run() {
        System.out.println("== 명언 앱 ==");

        long lastQuotationaId = 0;

        while (true) {
            final String cmd = scanner.nextLine().trim();

            if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                final String content = scanner.nextLine().trim();
                System.out.print("작가 : ");
                final String authorName = scanner.nextLine().trim();

                final long id = ++lastQuotationaId;

                System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
            } else if (cmd.equals("종료")) return;
        }
    }
}
