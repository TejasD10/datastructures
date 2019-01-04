package com.zzz.tutorial.java8;

import java.util.function.Consumer;

public class LoanPattern {

    /**
     * This class acts as a mail builder which is responsible for
     * creating and sending emails
     * We will incorporate the method chaining pattern and loan pattern.
     */
    public static class MailBuilder{
        // Make the constructor private
        private String from;
        private String to;
        private String subject;
        private String body;

        private MailBuilder() {}

        public MailBuilder from(String from) {
            this.from = from;
            return this;
        }
        public MailBuilder to(String to) {
            this.to = to;
            return this;
        }
        public MailBuilder subject(String subject) {
            this.subject = subject;
            return this;
        }
        public MailBuilder body(String body) {
            this.body = body;
            return this;
        }
        /*
        Make the send method static so it can be used to create and
        execute the block of code passed in on the instance
         */
        public static void send(Consumer<MailBuilder> block){
            final MailBuilder builder = new MailBuilder();
            block.accept(builder);
            System.out.println("sending mail..");
        }
    }
    public static void main(String[] args) {
        MailBuilder.send(mailer ->
                mailer.from("abcFrom")
                    .to("abcTo")
                    .subject("Subject")
                    .body("Body"));
    }
}
