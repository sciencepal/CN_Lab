package com.crashlytics.android.answers;

public class LevelStartEvent extends PredefinedEvent<LevelStartEvent> {
    static final String LEVEL_NAME_ATTRIBUTE = "levelName";
    static final String TYPE = "levelStart";

    public LevelStartEvent putLevelName(String str) {
        this.predefinedAttributes.put(LEVEL_NAME_ATTRIBUTE, str);
        return this;
    }

    String getPredefinedType() {
        return TYPE;
    }
}
