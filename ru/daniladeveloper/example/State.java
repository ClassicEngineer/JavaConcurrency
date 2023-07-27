package ru.daniladeveloper.example;

public class State {

        public State() {
        }

        private String stringState = "state";

        private boolean boolState = false;

        public synchronized void setBoolSynState(boolean b) {
            this.boolState = b;
            this.stringState = "changed";
        }

        public void setBoolState(boolean b) {
            boolState = b;
         }


    @Override
    public String toString() {
        return "Stateful{" +
            "stringState='" + stringState + '\'' +
            ", boolState=" + boolState +
            '}';
    }
}
