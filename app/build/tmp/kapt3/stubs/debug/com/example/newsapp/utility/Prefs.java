package com.example.newsapp.utility;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u001d\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u000fJ\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0014\u00a2\u0006\u0002\u0010\u0015J\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0017\u00a2\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007J$\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001b2\u0006\u0010\f\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u001dJ\u0016\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000bJ\u0016\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0011J\u0016\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0014J\u0016\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0017J\u0016\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007J\u001c\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u001bR\u001b\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u0007\u0012\u0002\b\u00030\u00068F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006#"}, d2 = {"Lcom/example/newsapp/utility/Prefs;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "all", "", "", "getAll", "()Ljava/util/Map;", "contains", "", "key", "getBoolean", "defValue", "(Ljava/lang/String;Z)Ljava/lang/Boolean;", "getFloat", "", "(Ljava/lang/String;F)Ljava/lang/Float;", "getInt", "", "(Ljava/lang/String;I)Ljava/lang/Integer;", "getLong", "", "(Ljava/lang/String;J)Ljava/lang/Long;", "getString", "getStringSet", "", "remove", "", "removeAll", "save", "value", "Builder", "Companion", "app_debug"})
public final class Prefs {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG = "Prefs";
    @org.jetbrains.annotations.Nullable
    private static com.example.newsapp.utility.Prefs singleton;
    @org.jetbrains.annotations.Nullable
    private static android.content.SharedPreferences preferences;
    @org.jetbrains.annotations.Nullable
    private static android.content.SharedPreferences.Editor editor;
    @org.jetbrains.annotations.NotNull
    public static final com.example.newsapp.utility.Prefs.Companion Companion = null;
    
    public Prefs(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, ?> getAll() {
        return null;
    }
    
    public final void save(@org.jetbrains.annotations.NotNull
    java.lang.String key, boolean value) {
    }
    
    public final void save(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    public final void save(@org.jetbrains.annotations.NotNull
    java.lang.String key, int value) {
    }
    
    public final void save(@org.jetbrains.annotations.NotNull
    java.lang.String key, float value) {
    }
    
    public final void save(@org.jetbrains.annotations.NotNull
    java.lang.String key, long value) {
    }
    
    public final void save(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    java.util.Set<java.lang.String> value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean getBoolean(@org.jetbrains.annotations.NotNull
    java.lang.String key, boolean defValue) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getString(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    java.lang.String defValue) {
        return null;
    }
    
    public final boolean contains(@org.jetbrains.annotations.NotNull
    java.lang.String key) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getInt(@org.jetbrains.annotations.NotNull
    java.lang.String key, int defValue) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Float getFloat(@org.jetbrains.annotations.NotNull
    java.lang.String key, float defValue) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getLong(@org.jetbrains.annotations.NotNull
    java.lang.String key, long defValue) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Set<java.lang.String> getStringSet(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    java.util.Set<java.lang.String> defValue) {
        return null;
    }
    
    public final void remove(@org.jetbrains.annotations.NotNull
    java.lang.String key) {
    }
    
    public final void removeAll() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/example/newsapp/utility/Prefs$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "build", "Lcom/example/newsapp/utility/Prefs;", "app_debug"})
    static final class Builder {
        @org.jetbrains.annotations.NotNull
        private final android.content.Context context = null;
        
        public Builder(@org.jetbrains.annotations.Nullable
        android.content.Context context) {
            super();
        }
        
        /**
         * Method that creates an instance of Prefs
         *
         * @return an instance of Prefs
         */
        @org.jetbrains.annotations.NotNull
        public final com.example.newsapp.utility.Prefs build() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/newsapp/utility/Prefs$Companion;", "", "()V", "TAG", "", "getTAG$app_debug", "()Ljava/lang/String;", "editor", "Landroid/content/SharedPreferences$Editor;", "getEditor$app_debug", "()Landroid/content/SharedPreferences$Editor;", "setEditor$app_debug", "(Landroid/content/SharedPreferences$Editor;)V", "preferences", "Landroid/content/SharedPreferences;", "getPreferences$app_debug", "()Landroid/content/SharedPreferences;", "setPreferences$app_debug", "(Landroid/content/SharedPreferences;)V", "singleton", "Lcom/example/newsapp/utility/Prefs;", "with", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getTAG$app_debug() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.content.SharedPreferences getPreferences$app_debug() {
            return null;
        }
        
        public final void setPreferences$app_debug(@org.jetbrains.annotations.Nullable
        android.content.SharedPreferences p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.content.SharedPreferences.Editor getEditor$app_debug() {
            return null;
        }
        
        public final void setEditor$app_debug(@org.jetbrains.annotations.Nullable
        android.content.SharedPreferences.Editor p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.newsapp.utility.Prefs with(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
}