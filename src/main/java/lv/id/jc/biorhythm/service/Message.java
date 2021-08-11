package lv.id.jc.biorhythm.service;

import lv.id.jc.biorhythm.ui.Component;

public class Message extends Component {
    public Message(String message) {
        runnable = () -> printf(message);
    }
}
