package com.example.newsapp.utility;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/example/newsapp/utility/Utility;", "", "()V", "Companion", "OnDateSelection", "OnDateTimeSelection", "app_debug"})
public final class Utility {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String yyyy_MM_dd_T_HHmmssZ = "yyyy-MM-dd\'T\'HH:mm:ss.SSSSSS\'Z\'";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String MMM_DD_EEE = "MMM dd, EEE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String HH_MM = "HH:mm";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DAY_DD_MMM_YYYY = "EEE, dd MMM yyyy";
    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60000;
    private static final int HOUR_MILLIS = 3600000;
    private static final int DAY_MILLIS = 86400000;
    private static final int SECOND = 1;
    private static final int MINUTE = 60;
    private static final int HOUR = 3600;
    private static final int DAY = 86400;
    private static final int WEEK = 604800;
    private static final int MONTH = 2592000;
    private static final int YEAR = 31104000;
    @org.jetbrains.annotations.NotNull
    public static final com.example.newsapp.utility.Utility.Companion Companion = null;
    
    public Utility() {
        super();
    }
    
    @kotlin.jvm.JvmStatic
    public static final boolean checkGender(@org.jetbrains.annotations.NotNull
    java.lang.String genderStr, @org.jetbrains.annotations.NotNull
    java.lang.String checkStr) {
        return false;
    }
    
    @kotlin.jvm.JvmStatic
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String duration(@org.jetbrains.annotations.Nullable
    java.lang.String startDate, @org.jetbrains.annotations.Nullable
    java.lang.String endDate, @org.jetbrains.annotations.Nullable
    java.lang.String inputFormat, @org.jetbrains.annotations.Nullable
    java.lang.String outputFormat) {
        return null;
    }
    
    @kotlin.jvm.JvmStatic
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String formatDate(@org.jetbrains.annotations.Nullable
    java.lang.String date, @org.jetbrains.annotations.Nullable
    java.lang.String inputFormat, @org.jetbrains.annotations.Nullable
    java.lang.String outputFormat) {
        return null;
    }
    
    @kotlin.jvm.JvmStatic
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String strNullOrEmpty(@org.jetbrains.annotations.Nullable
    java.lang.String string) {
        return null;
    }
    
    @kotlin.jvm.JvmStatic
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String twoStringConcat(@org.jetbrains.annotations.Nullable
    java.lang.String str1, @org.jetbrains.annotations.Nullable
    java.lang.String str2) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0007J\u0018\u0010\u001c\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\u0006J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010\u0006J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004J\u0016\u0010&\u001a\u00020\u00172\u0006\u0010\'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020.2\u0006\u00100\u001a\u000201J\u000e\u00102\u001a\u00020.2\u0006\u0010#\u001a\u00020$J\b\u00103\u001a\u000204H\u0002J\u000e\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0006J0\u00107\u001a\u00020\u00062\b\u00108\u001a\u0004\u0018\u00010\u00062\b\u00109\u001a\u0004\u0018\u00010\u00062\b\u0010:\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010;\u001a\u0004\u0018\u00010\u00062\b\u0010<\u001a\u0004\u0018\u00010\u0006J&\u0010=\u001a\u00020\u00062\b\u0010\'\u001a\u0004\u0018\u00010\u00062\b\u0010:\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0006H\u0007J\u0016\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u0006J\u0016\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\"J\u0016\u0010D\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$2\u0006\u0010E\u001a\u00020\u0006J\u001a\u0010F\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020\u00062\b\u0010G\u001a\u0004\u0018\u00010\u0006J\u0011\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00060I\u00a2\u0006\u0002\u0010JJ\u000e\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NJ\u0018\u0010O\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010\u0006J\u000e\u0010P\u001a\u00020\u00012\u0006\u0010Q\u001a\u00020\u0006J\u0018\u0010R\u001a\u00020\u00062\u0006\u0010S\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u0019J\u000e\u0010U\u001a\u00020\u00062\u0006\u0010M\u001a\u00020NJ\u0018\u0010V\u001a\u0004\u0018\u00010\u00062\u0006\u0010W\u001a\u00020X2\u0006\u0010#\u001a\u00020$J\u0016\u0010Y\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$2\u0006\u0010\'\u001a\u000204J\u000e\u0010Z\u001a\u00020\u00062\u0006\u0010\'\u001a\u000204J\u000e\u0010[\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$J\u000e\u0010\\\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$J\u000e\u0010]\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$J\u0010\u0010^\u001a\u00020\u00192\b\u0010_\u001a\u0004\u0018\u00010\u0006J\u000e\u0010`\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$J\u0010\u0010a\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0007J\u0006\u0010b\u001a\u00020\u0019J\u0010\u0010c\u001a\u00020\u00192\b\u0010d\u001a\u0004\u0018\u00010\u0006J\u0010\u0010e\u001a\u00020\u00192\b\u0010f\u001a\u0004\u0018\u00010\u0006J\u0010\u0010g\u001a\u00020\u00192\b\u0010Q\u001a\u0004\u0018\u00010\u0006J\u0010\u0010h\u001a\u00020\u00192\b\u0010i\u001a\u0004\u0018\u00010\u0006J\u0016\u0010j\u001a\u00020*2\u0006\u0010#\u001a\u00020$2\u0006\u0010k\u001a\u00020\u0006J\u0016\u0010l\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\"J\u000e\u0010n\u001a\u00020*2\u0006\u0010#\u001a\u00020$J2\u0010o\u001a\u00020*2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010p\u001a\u0004\u0018\u00010\u00172\b\u0010q\u001a\u0004\u0018\u00010\u00172\u0006\u0010r\u001a\u00020sJ2\u0010t\u001a\u00020*2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010p\u001a\u0004\u0018\u00010\u00172\b\u0010q\u001a\u0004\u0018\u00010\u00172\u0006\u0010r\u001a\u00020uJ\u0016\u0010v\u001a\u00020*2\u0006\u0010#\u001a\u00020$2\u0006\u0010w\u001a\u00020\u0006J\u0016\u0010x\u001a\u00020*2\u0006\u0010#\u001a\u00020$2\u0006\u0010_\u001a\u00020\u0006J\u0016\u0010y\u001a\u00020*2\u0006\u0010#\u001a\u00020$2\u0006\u0010Q\u001a\u00020\u0006J\u000e\u0010z\u001a\u00020\u00062\u0006\u0010{\u001a\u00020LJ&\u0010|\u001a\u00020*2\u0006\u0010#\u001a\u00020$2\u0006\u0010}\u001a\u00020\u00062\u0006\u0010~\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020\u0006J\u001c\u0010\u0080\u0001\u001a\u00020*2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010$2\b\u0010\u007f\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u0082\u0001\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0007\u0010\u0083\u0001\u001a\u00020\"J\u0013\u0010\u0084\u0001\u001a\u00020\u00062\b\u0010d\u001a\u0004\u0018\u00010\u0006H\u0007J\u001f\u0010\u0085\u0001\u001a\u00020\u00062\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0006H\u0007J\u0019\u0010\u0088\u0001\u001a\u0004\u0018\u00010.2\u0006\u0010#\u001a\u00020$2\u0006\u0010W\u001a\u00020XJ\u0015\u0010\u0089\u0001\u001a\u00020**\u00020$2\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u008c\u0001"}, d2 = {"Lcom/example/newsapp/utility/Utility$Companion;", "", "()V", "DAY", "", "DAY_DD_MMM_YYYY", "", "DAY_MILLIS", "HH_MM", "HOUR", "HOUR_MILLIS", "MINUTE", "MINUTE_MILLIS", "MMM_DD_EEE", "MONTH", "SECOND", "SECOND_MILLIS", "WEEK", "YEAR", "YYYY_MM_DD_HH_MM_SS", "yyyy_MM_dd_T_HHmmssZ", "calculateAge", "calendar", "Ljava/util/Calendar;", "checkGender", "", "genderStr", "checkStr", "checkStringValue", "inputString", "outputIfNullString", "convertCalendarToString", "outputFormat", "convertDpToPx", "", "context", "Landroid/content/Context;", "dp", "convertStringToCalendar", "date", "dateFormat", "copyInputStreamToFile", "", "inputStream", "Ljava/io/InputStream;", "file", "Ljava/io/File;", "createAppFolder", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "createImageFile", "currentDate", "Ljava/util/Date;", "downloadUrl", "strUrl", "duration", "startDate", "endDate", "inputFormat", "extractYTId", "ytUrl", "formatDate", "getAge", "dobString", "dateFormet", "getColorWithAlpha", "color", "ratio", "getCurrencySymbol", "currencySymbol", "getCurrentDateAndTime", "timeZone", "getDocumentMimeTypes", "", "()[Ljava/lang/String;", "getFileSize", "", "size", "", "getFormattedDateTime", "getGlideUrl", "url", "getHtmlText", "mainString", "forDisplay", "getReadableFileSize", "getRealPathFromURI", "uri", "Landroid/net/Uri;", "getTimeAgo", "getTimeAgoTemp", "getUserAgent", "hasNetworkAvailable", "isAppIsInBackground", "isEmailValid", "email", "isInternetAvailable", "isNetworkOnline1", "isNetworkOnline3", "isNullOrEmpty", "string", "isPhoneNumValid", "num", "isUrlValid", "isValidPassword", "password", "logScreenViewEvent", "module", "manipulateColor", "factor", "openApp", "openDatePicker", "maxDateSelection", "minDateSelection", "onDateSelection", "Lcom/example/newsapp/utility/Utility$OnDateSelection;", "openDateTimePicker", "Lcom/example/newsapp/utility/Utility$OnDateTimeSelection;", "openDialPad", "mobileNumber", "openEmail", "openIntentUrl", "roundOffDecimal", "number", "sendEmail", "recipient", "subject", "message", "showToast", "mContext", "spToPx", "sp", "strNullOrEmpty", "twoStringConcat", "str1", "str2", "uriToImageFile", "hideKeyboard", "view", "Landroid/view/View;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final int manipulateColor(int color, float factor) {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getReadableFileSize(long size) {
            return null;
        }
        
        public final double getFileSize(long size) {
            return 0.0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.Object getGlideUrl(@org.jetbrains.annotations.NotNull
        java.lang.String url) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.io.File createAppFolder(@org.jetbrains.annotations.NotNull
        androidx.appcompat.app.AppCompatActivity activity) {
            return null;
        }
        
        public final void hideKeyboard(@org.jetbrains.annotations.NotNull
        android.content.Context $this$hideKeyboard, @org.jetbrains.annotations.NotNull
        android.view.View view) {
        }
        
        public final boolean isEmailValid(@org.jetbrains.annotations.Nullable
        java.lang.String email) {
            return false;
        }
        
        public final boolean isUrlValid(@org.jetbrains.annotations.Nullable
        java.lang.String url) {
            return false;
        }
        
        public final boolean isPhoneNumValid(@org.jetbrains.annotations.Nullable
        java.lang.String num) {
            return false;
        }
        
        public final boolean isValidPassword(@org.jetbrains.annotations.Nullable
        java.lang.String password) {
            return false;
        }
        
        @kotlin.Suppress(names = {"DEPRECATION"})
        public final boolean hasNetworkAvailable(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return false;
        }
        
        public final boolean isInternetAvailable(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return false;
        }
        
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        public final java.lang.String formatDate(@org.jetbrains.annotations.Nullable
        java.lang.String date, @org.jetbrains.annotations.Nullable
        java.lang.String inputFormat, @org.jetbrains.annotations.Nullable
        java.lang.String outputFormat) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String convertCalendarToString(@org.jetbrains.annotations.NotNull
        java.util.Calendar calendar, @org.jetbrains.annotations.Nullable
        java.lang.String outputFormat) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.Calendar convertStringToCalendar(@org.jetbrains.annotations.NotNull
        java.lang.String date, @org.jetbrains.annotations.NotNull
        java.lang.String dateFormat) {
            return null;
        }
        
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        public final java.lang.String duration(@org.jetbrains.annotations.Nullable
        java.lang.String startDate, @org.jetbrains.annotations.Nullable
        java.lang.String endDate, @org.jetbrains.annotations.Nullable
        java.lang.String inputFormat, @org.jetbrains.annotations.Nullable
        java.lang.String outputFormat) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getFormattedDateTime(@org.jetbrains.annotations.NotNull
        java.util.Calendar calendar, @org.jetbrains.annotations.Nullable
        java.lang.String outputFormat) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getCurrentDateAndTime(@org.jetbrains.annotations.NotNull
        java.lang.String outputFormat, @org.jetbrains.annotations.Nullable
        java.lang.String timeZone) {
            return null;
        }
        
        public final boolean isNullOrEmpty(@org.jetbrains.annotations.Nullable
        java.lang.String string) {
            return false;
        }
        
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        public final java.lang.String strNullOrEmpty(@org.jetbrains.annotations.Nullable
        java.lang.String string) {
            return null;
        }
        
        public final void openApp(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getUserAgent(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
        
        @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
        @org.jetbrains.annotations.NotNull
        public final java.io.File createImageFile(@org.jetbrains.annotations.NotNull
        android.content.Context context) throws java.io.IOException {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.io.File uriToImageFile(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        android.net.Uri uri) {
            return null;
        }
        
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        public final java.lang.String twoStringConcat(@org.jetbrains.annotations.Nullable
        java.lang.String str1, @org.jetbrains.annotations.Nullable
        java.lang.String str2) {
            return null;
        }
        
        @kotlin.jvm.JvmStatic
        public final boolean checkGender(@org.jetbrains.annotations.NotNull
        java.lang.String genderStr, @org.jetbrains.annotations.NotNull
        java.lang.String checkStr) {
            return false;
        }
        
        @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
        public final void copyInputStreamToFile(@org.jetbrains.annotations.NotNull
        java.io.InputStream inputStream, @org.jetbrains.annotations.NotNull
        java.io.File file) throws java.io.IOException {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCurrencySymbol(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        java.lang.String currencySymbol) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String roundOffDecimal(double number) {
            return null;
        }
        
        public final void openIntentUrl(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        java.lang.String url) {
        }
        
        public final void openEmail(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        java.lang.String email) {
        }
        
        public final void openDialPad(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        java.lang.String mobileNumber) {
        }
        
        public final void sendEmail(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        java.lang.String recipient, @org.jetbrains.annotations.NotNull
        java.lang.String subject, @org.jetbrains.annotations.NotNull
        java.lang.String message) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String downloadUrl(@org.jetbrains.annotations.NotNull
        java.lang.String strUrl) {
            return null;
        }
        
        public final void showToast(@org.jetbrains.annotations.Nullable
        android.content.Context mContext, @org.jetbrains.annotations.Nullable
        java.lang.String message) {
        }
        
        public final int getColorWithAlpha(int color, float ratio) {
            return 0;
        }
        
        public final int getAge(@org.jetbrains.annotations.NotNull
        java.lang.String dobString, @org.jetbrains.annotations.NotNull
        java.lang.String dateFormet) {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String checkStringValue(@org.jetbrains.annotations.Nullable
        java.lang.String inputString, @org.jetbrains.annotations.NotNull
        java.lang.String outputIfNullString) {
            return null;
        }
        
        public final void openDatePicker(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        java.util.Calendar calendar, @org.jetbrains.annotations.Nullable
        java.util.Calendar maxDateSelection, @org.jetbrains.annotations.Nullable
        java.util.Calendar minDateSelection, @org.jetbrains.annotations.NotNull
        com.example.newsapp.utility.Utility.OnDateSelection onDateSelection) {
        }
        
        public final void openDateTimePicker(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        java.util.Calendar calendar, @org.jetbrains.annotations.Nullable
        java.util.Calendar maxDateSelection, @org.jetbrains.annotations.Nullable
        java.util.Calendar minDateSelection, @org.jetbrains.annotations.NotNull
        com.example.newsapp.utility.Utility.OnDateTimeSelection onDateSelection) {
        }
        
        private final java.util.Date currentDate() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getTimeAgo(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        java.util.Date date) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getTimeAgoTemp(@org.jetbrains.annotations.NotNull
        java.util.Date date) {
            return null;
        }
        
        public final boolean isNetworkOnline3() {
            return false;
        }
        
        @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.M)
        public final boolean isNetworkOnline1(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getRealPathFromURI(@org.jetbrains.annotations.NotNull
        android.net.Uri uri, @org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
        
        public final boolean isAppIsInBackground(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String[] getDocumentMimeTypes() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String extractYTId(@org.jetbrains.annotations.Nullable
        java.lang.String ytUrl) {
            return null;
        }
        
        public final int spToPx(@org.jetbrains.annotations.NotNull
        android.content.Context context, float sp) {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getHtmlText(@org.jetbrains.annotations.NotNull
        java.lang.String mainString, boolean forDisplay) {
            return null;
        }
        
        public final void logScreenViewEvent(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        java.lang.String module) {
        }
        
        public final float convertDpToPx(@org.jetbrains.annotations.NotNull
        android.content.Context context, int dp) {
            return 0.0F;
        }
        
        public final int calculateAge(@org.jetbrains.annotations.NotNull
        java.util.Calendar calendar) {
            return 0;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/example/newsapp/utility/Utility$OnDateSelection;", "", "onDateSelect", "", "day", "", "month", "year", "app_debug"})
    public static abstract interface OnDateSelection {
        
        public abstract void onDateSelect(int day, int month, int year);
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/newsapp/utility/Utility$OnDateTimeSelection;", "", "onDateTimeSelect", "", "pickedDateTime", "Ljava/util/Calendar;", "app_debug"})
    public static abstract interface OnDateTimeSelection {
        
        public abstract void onDateTimeSelect(@org.jetbrains.annotations.NotNull
        java.util.Calendar pickedDateTime);
    }
}