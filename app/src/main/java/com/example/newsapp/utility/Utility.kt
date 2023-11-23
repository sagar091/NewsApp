package com.example.newsapp.utility

//import com.bumptech.glide.load.model.GlideUrl
//import com.bumptech.glide.load.model.LazyHeaders
//import com.communageapp.R
//import com.communageapp.model.*
import android.annotation.TargetApi
import android.app.Activity
import android.app.ActivityManager
import android.app.ActivityManager.RunningAppProcessInfo
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.util.Log
import android.util.Patterns
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.text.DecimalFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.roundToInt


class Utility {

    companion object {

        const val yyyy_MM_dd_T_HHmmssZ = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'";
        const val MMM_DD_EEE = "MMM dd, EEE";
        const val HH_MM = "HH:mm"
        const val YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss"
        const val DAY_DD_MMM_YYYY = "EEE, dd MMM yyyy"


        private const val SECOND_MILLIS = 1000
        private const val MINUTE_MILLIS = 60 * SECOND_MILLIS
        private const val HOUR_MILLIS = 60 * MINUTE_MILLIS
        private const val DAY_MILLIS = 24 * HOUR_MILLIS

        private const val SECOND = 1
        private const val MINUTE = 60 * SECOND
        private const val HOUR = 60 * MINUTE
        private const val DAY = 24 * HOUR
        private const val WEEK = 7 * DAY
        private const val MONTH = 30 * DAY
        private const val YEAR = 12 * MONTH

        fun manipulateColor(color: Int, factor: Float): Int {
            val a = Color.alpha(color)
            val r = (Color.red(color) * factor).roundToInt()
            val g = (Color.green(color) * factor).roundToInt()
            val b = (Color.blue(color) * factor).roundToInt()
            return Color.argb(
                a, r.coerceAtMost(255), g.coerceAtMost(255), b.coerceAtMost(255)
            )
        }

        fun getReadableFileSize(size: Long): String {
            if (size <= 0) {
                return "0"
            }
            val units = arrayOf("B", "KB", "MB", "GB", "TB")
            val digitGroups = (log10(size.toDouble()) / log10(1024.0)).toInt()
            return DecimalFormat("#,##0.#").format(size / 1024.0.pow(digitGroups.toDouble())) + " " + units[digitGroups]
        }

        fun getFileSize(size: Long): Double {
            if (size <= 0) {
                return 0.0
            }
            return ((size / 1024).toDouble())
        }

        fun getGlideUrl(url: String): Any {
            /*if (url.startsWith("http")) {
                return GlideUrl(
                    url, LazyHeaders.Builder().addHeader("User-Agent", "5").build()
                )
            } else {
                return url
            }*/
            return url
        }

        fun createAppFolder(activity: AppCompatActivity): File {
            val file = File(activity.getExternalFilesDir(null), "/TempImage")
            if (!file.exists()) {
                file.mkdir()
            }
            return file
        }

        fun Context.hideKeyboard(view: View) {
            val inputMethodManager =
                getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }

        //  2022-02-20 16:30:00
        fun isEmailValid(email: String?): Boolean {

            //String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            // String expression ="[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$";
            //Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            //Matcher matcher = pattern.matcher(email);
            //return matcher.matches();
            return Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        fun isUrlValid(url: String?): Boolean {
            return Patterns.WEB_URL.matcher(url).matches()
        }

        fun isPhoneNumValid(num: String?): Boolean {
            return Patterns.PHONE.matcher(num).matches()
        }

        fun isValidPassword(password: String?): Boolean {
            val passwordPattern =
                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"
            val pattern = Pattern.compile(passwordPattern)
            val machter = pattern.matcher(password)
            return machter.matches()
        }

        // check internet connectivity
        // Returns connection type. 0: none; 1: mobile data; 2: wifi
        @Suppress("DEPRECATION")
        fun hasNetworkAvailable(context: Context): Boolean {

            val connectivity =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = connectivity.allNetworkInfo
            for (value in info) if (value.state == NetworkInfo.State.CONNECTED) {
                return true
            }
            return false
        }

        fun isInternetAvailable(context: Context): Boolean {
            var isOnline: Boolean
            val manager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val capabilities: NetworkCapabilities? =
                manager.getNetworkCapabilities(manager.activeNetwork)
            isOnline =
                capabilities != null && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED);
            return isOnline
        }

        // changing date-time formatting
        @JvmStatic
        fun formatDate(date: String?, inputFormat: String?, outputFormat: String?): String {
            var result = ""
            var inputSDF: SimpleDateFormat?
            var outputSDF: SimpleDateFormat?
            try {
                inputSDF = SimpleDateFormat(inputFormat, Locale.US)
                outputSDF = SimpleDateFormat(outputFormat, Locale.US)
                result = outputSDF.format(inputSDF.parse(date))
            } catch (e: Exception) {
                e.printStackTrace()
                return ""
            } finally {
                inputSDF = null
                outputSDF = null
            }
            return result
        }

        fun convertCalendarToString(calendar: Calendar, outputFormat: String?): String {
            val formatter = SimpleDateFormat(outputFormat, Locale.getDefault())
            return formatter.format(calendar.time)
        }

        fun convertStringToCalendar(date: String, dateFormat: String): Calendar {
            // Create a SimpleDateFormat object with the format of the string.
            val simpleDateFormat = SimpleDateFormat(dateFormat, Locale.getDefault())

            // Parse the string to a Date object using the SimpleDateFormat object.
            val date = simpleDateFormat.parse(date)

            // Create a Calendar object from the Date object.
            val calendar = Calendar.getInstance()
            calendar.time = date
            return calendar
        }


        @JvmStatic
        fun duration(
            startDate: String?, endDate: String?, inputFormat: String?, outputFormat: String?
        ): String {
            // formatDate(startDate,inputFormat,outputFormat)
            //AppLogger.e(startDate,endDate)
            return formatDate(startDate, inputFormat, outputFormat) + " - " + formatDate(
                endDate, inputFormat, outputFormat
            )
        }

        // get date/time formatted string from calendar object
        fun getFormattedDateTime(calendar: Calendar, outputFormat: String?): String {
            val sdf = SimpleDateFormat(outputFormat, Locale.US)
            return sdf.format(calendar.time)
        }

        // get current date-time in specific format, timZone is optional.. can keep blank or null
        fun getCurrentDateAndTime(outputFormat: String, timeZone: String?): String? {
            val c = Calendar.getInstance()
            val df = SimpleDateFormat(outputFormat, Locale.US)
            if (!isNullOrEmpty(timeZone)) {
                df.timeZone = TimeZone.getTimeZone(timeZone)
            }
            return df.format(c.time)
        }

        // check null/empty/blank/NA value
        fun isNullOrEmpty(string: String?): Boolean {
            return string == null || string == "" || string == " " || string == "N/A" || string == "n/a" || string == "NA" || string == "na" || string == "null"
        }

        @JvmStatic
        fun strNullOrEmpty(string: String?): String {
            if (string == null || string == "" || string == " " || string == "N/A" || string == "n/a" || string == "NA" || string == "na") {
                return "";
            } else {
                return string
            }
//            return string == null || string == "" || string == " " || string == "N/A" || string ==
//                    "n/a" || string == "NA" || string == "na"
        }

        // open app on play store
        fun openApp(context: Context) {
            val appPackageName = context.packageName

            try {
                context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName")
                    )
                )
            } catch (exce: ActivityNotFoundException) {
                context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
                    )
                )
            }
            (context as Activity).overridePendingTransition(
                android.R.anim.fade_in, android.R.anim.fade_out
            )
        }

        // clear session, called on logout
//        fun clearSession(context: Context) {
//            PrefUtils.logout(context)
//        }

        // clear everything, called on delete account
        /*fun deleteUserData(context: Context) {
            PrefUtils.clearAll(context)
            context.fireIntent(SplashActivity::class.java, true)
        }
*/
        // get user_agent
        fun getUserAgent(context: Context): String {
            val device = Build.DEVICE
            val platform = "Android"
            var version = ""
            var userAgent = ""

            val manager: PackageManager = context.packageManager
            val info: PackageInfo

            try {
                info = manager.getPackageInfo(context.packageName, 0)
                version = info.versionName
            } catch (e: PackageManager.NameNotFoundException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
            userAgent = "$device;$platform $version"
            return userAgent
        }

        // create temp file at Android/data/com.paysme.cabappdriver/files/Pictures
        @Throws(IOException::class)
        fun createImageFile(context: Context): File {
            // Create an image file name
            val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
            val imageFileName = "PNG_" + timeStamp + "_"
            val storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            val image = File.createTempFile(
                imageFileName, /* prefix */
                ".png", /* suffix */
                storageDir      /* directory */
            )

            // Save a file: path for use with ACTION_VIEW intents
            // image.absolutePath
            return image
        }

        // Convert Uri to File
        fun uriToImageFile(context: Context, uri: Uri): File? {
            val filePathColumn = arrayOf(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString())
            val cursor = context.contentResolver?.query(uri, filePathColumn, null, null, null)
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    val columnIndex = cursor.getColumnIndex(filePathColumn[0])
                    val filePath = cursor.getString(columnIndex)
                    cursor.close()
                    return File(filePath)
                }
                cursor.close()
            }
            return null
        }

        @JvmStatic
        fun twoStringConcat(str1: String?, str2: String?): String {
            if (!str1.isNullOrEmpty() && !str2.isNullOrEmpty()) {
                return str1.plus(" $str2")
            } else {
                return ""
            }
        }

        @JvmStatic
        fun checkGender(genderStr: String, checkStr: String): Boolean {
            return genderStr.equals(checkStr)
        }

        // Copy InputStream data to a File
        @Throws(IOException::class)
        fun copyInputStreamToFile(inputStream: InputStream, file: File) {

            // append = false
            FileOutputStream(file, false).use { outputStream ->
                var read: Int
                val bytes = ByteArray(DEFAULT_BUFFER_SIZE)
                while (inputStream.read(bytes).also { read = it } != -1) {
                    outputStream.write(bytes, 0, read)
                }
            }
        }

        fun getCurrencySymbol(context: Context, currencySymbol: String): String {
            return if (!isNullOrEmpty(currencySymbol)) HtmlCompat.fromHtml(
                currencySymbol,
                HtmlCompat.FROM_HTML_MODE_LEGACY
            ).toString()
            else "£"
        }

        fun roundOffDecimal(number: Double): String {
            return String.format("%.2f", number)
        }

        // open web url using intent
        fun openIntentUrl(context: Context, url: String) {
            var newUrl = url
            if (!newUrl.startsWith("https://") && !newUrl.startsWith("http://")) {
                newUrl = "https://$newUrl"
            }
            try {
                context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW, Uri.parse(newUrl)
                    ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun openEmail(context: Context, email: String) {
            /*try {
                val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email"))
                context.startActivity(
                    Intent.createChooser(
                        emailIntent, context.getString(R.string.send_mail)
                    )
                )

            } catch (e: Exception) {
                e.printStackTrace()
            }*/
        }

        // open dial pad for call
        fun openDialPad(context: Context, mobileNumber: String) {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel: $mobileNumber")
            context.startActivity(intent)
        }

        //send mail through intent
        fun sendEmail(
            context: Context,
            recipient: String,
            subject: String,
            message: String
        ) {/*ACTION_SEND action to launch an email client installed on your Android device.*/
            val mIntent = Intent(Intent.ACTION_SEND)/*To send an email you need to specify mailto: as URI using setData() method
            and data type will be to text/plain using setType() method*/
            mIntent.data = Uri.parse("mailto:")
            mIntent.type = "text/plain"
            // put recipient email in intent
            /* recipient is put as array because you may wanna send email to multiple emails
               so enter comma(,) separated emails, it will be stored in array*/
            mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
            //put the Subject in the intent
            mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
            //put the message in the intent
            mIntent.putExtra(Intent.EXTRA_TEXT, message)


            try {
                //start email intent
                context.startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
            } catch (e: Exception) {
                //if any thing goes wrong for example no email client application or any exception
                //get and show exception message
                showToast(context, e.message)
            }

        }

        // bitmap from vector drawable
        /*fun bitmapFromVector(context: Context, vectorResId: Int): BitmapDescriptor? {
            // below line is use to generate a drawable.
            val vectorDrawable = ContextCompat.getDrawable(context, vectorResId)

            // below line is use to set bounds to our vector drawable.
            vectorDrawable!!.setBounds(
                0, 0, vectorDrawable.intrinsicWidth, vectorDrawable.intrinsicHeight
            )

            // below line is use to create a bitmap for our
            // drawable which we have added.
            val bitmap = Bitmap.createBitmap(
                vectorDrawable.intrinsicWidth,
                vectorDrawable.intrinsicHeight,
                Bitmap.Config.ARGB_8888
            )

            // below line is use to add bitmap in our canvas.
            val canvas = Canvas(bitmap)

            // below line is use to draw our
            // vector drawable in canvas.
            vectorDrawable.draw(canvas)

            // after generating our bitmap we are returning our bitmap.
            return BitmapDescriptorFactory.fromBitmap(bitmap)
        }*/

        fun downloadUrl(strUrl: String): String {

            var data = ""
            var iStream: InputStream? = null
            var urlConnection: HttpURLConnection? = null
            try {
                val url = URL(strUrl)
                urlConnection = url.openConnection() as HttpURLConnection
                urlConnection.connect()
                iStream = urlConnection.getInputStream()
                val br = BufferedReader(InputStreamReader(iStream))
                val sb = StringBuffer()
                var line: String? = ""
                while (br.readLine().also { line = it } != null) {
                    sb.append(line)
                }
                data = sb.toString()
                br.close()
            } catch (e: Exception) {
                Log.d("Exception", e.toString())
            } finally {
                iStream?.close()
                urlConnection?.disconnect()
            }

            return data
        }


        fun showToast(mContext: Context?, message: String?) {
            if (mContext != null && message != null) Toast.makeText(
                mContext, message, Toast.LENGTH_LONG
            ).show()
        }

        fun getColorWithAlpha(color: Int, ratio: Float): Int {
            var newColor = 0
            val alpha = Math.round(Color.alpha(color) * ratio).toInt()
            val r: Int = Color.red(color)
            val g: Int = Color.green(color)
            val b: Int = Color.blue(color)
            newColor = Color.argb(alpha, r, g, b)
            return newColor
        }

        fun getAge(dobString: String, dateFormet: String): Int {
            var date: Date? = null
            val sdf = SimpleDateFormat(dateFormet)
            try {
                date = sdf.parse(dobString)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            if (date == null) return 0
            val dob = Calendar.getInstance()
            val today = Calendar.getInstance()
            dob.time = date
            val year = dob[Calendar.YEAR]
            val month = dob[Calendar.MONTH]
            val day = dob[Calendar.DAY_OF_MONTH]
            dob[year, month + 1] = day
            var age = today[Calendar.YEAR] - dob[Calendar.YEAR]
            if (today[Calendar.DAY_OF_YEAR] < dob[Calendar.DAY_OF_YEAR]) {
                age--
            }
            return age
        }

        fun checkStringValue(inputString: String?, outputIfNullString: String): String {
            return if (inputString != null && inputString.toString().trim().isNotEmpty()) {
                inputString
            } else {
                outputIfNullString
            }
        }

        fun openDatePicker(
            context: Context,
            calendar: Calendar,
            maxDateSelection: Calendar?,
            minDateSelection: Calendar?,
            onDateSelection: OnDateSelection
        ) {
            val dpd = DatePickerDialog(
                context,
                { _, year, monthOfYear, dayOfMonth ->
                    onDateSelection.onDateSelect(dayOfMonth, monthOfYear, year)
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            maxDateSelection?.let {
                dpd.datePicker.maxDate = maxDateSelection.timeInMillis
            }
            minDateSelection?.let {
                dpd.datePicker.minDate = minDateSelection.timeInMillis
            }
            dpd.show()
        }

        fun openDateTimePicker(
            context: Context,
            calendar: Calendar,
            maxDateSelection: Calendar?,
            minDateSelection: Calendar?,
            onDateSelection: OnDateTimeSelection
        ) {
            val dpd = DatePickerDialog(
                context,
                { _, year, monthOfYear, dayOfMonth ->
                    // onDateSelection.onDateSelect(dayOfMonth, monthOfYear, year)
                    TimePickerDialog(
                        context,
                        { _, hour, minute ->
                            val pickedDateTime = Calendar.getInstance()
                            pickedDateTime.set(year, monthOfYear, dayOfMonth, hour, minute)
                            onDateSelection.onDateTimeSelect(pickedDateTime)
                        },
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE),
                        false
                    ).show()
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            maxDateSelection?.let {
                dpd.datePicker.maxDate = maxDateSelection.timeInMillis
            }
            minDateSelection?.let {
                dpd.datePicker.minDate = minDateSelection.timeInMillis
            }
            dpd.show()
        }


        private fun currentDate(): Date {
            val calendar = Calendar.getInstance()
            calendar.time = Date()
            return calendar.time
        }

        fun getTimeAgo(context: Context, date: Date): String {

            /*val time = date.time
            val d = currentDate()
            val now = d.time

            // convert back to second
            val diff = (now - time) / 1000
            return when {

                diff < SECOND -> context.getString(R.string.ago_second)
                diff < 59 * SECOND -> "${diff / SECOND} ${context.getString(R.string.ago_seconds)}"
                diff < 2 * MINUTE -> context.getString(R.string.ago_minute)
                diff < 60 * MINUTE -> "${diff / MINUTE} ${context.getString(R.string.ago_minutes)}"
                diff < 2 * HOUR -> context.getString(R.string.ago_hour)
                diff < 24 * HOUR -> "${diff / HOUR} ${context.getString(R.string.ago_hours)}"
                diff < 2 * DAY -> context.getString(R.string.ago_day)
                diff < 7 * DAY -> "${diff / DAY} ${context.getString(R.string.ago_days)}"
                diff < 1 * WEEK -> "${diff / WEEK} ${context.getString(R.string.ago_week)}"
                diff < 4 * WEEK -> "${diff / WEEK} ${context.getString(R.string.ago_weeks)}"
                diff < 2 * MONTH -> context.getString(R.string.ago_month)
                diff < 12 * MONTH -> "${diff / MONTH} ${context.getString(R.string.ago_months)}"
                diff < 2 * YEAR -> context.getString(R.string.ago_year)
                else -> "${diff / YEAR} ${context.getString(R.string.ago_years)}"

            }*/
            return ""
        }

        fun getTimeAgoTemp(date: Date): String {

            val time = date.time
            val d = currentDate()
            val now = d.time

            // convert back to second
            val diff = (now - time) / 1000
            return diff.toString()
        }

        fun isNetworkOnline3(): Boolean {
            var isOnline = false
            try {
                val url = URL("http://www.google.com") // or your server address
                // URL url = new URL("http://www.baidu.com");
                val conn = url.openConnection() as HttpURLConnection
                conn.setRequestProperty("Connection", "close")
                conn.connectTimeout = 3000
                isOnline = conn.responseCode == 200
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return isOnline
        }

        @TargetApi(Build.VERSION_CODES.M)
        fun isNetworkOnline1(context: Context): Boolean {
            var isOnline = false
            try {
                val manager =
                    context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val capabilities =
                    manager.getNetworkCapabilities(manager.activeNetwork) // need ACCESS_NETWORK_STATE permission
                isOnline =
                    capabilities != null && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
            return isOnline
        }


        fun getRealPathFromURI(uri: Uri, context: Context): String? {
            val returnCursor = context.contentResolver.query(uri, null, null, null, null)
            val nameIndex = returnCursor!!.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            val sizeIndex = returnCursor.getColumnIndex(OpenableColumns.SIZE)
            returnCursor.moveToFirst()
            val name = returnCursor.getString(nameIndex)
            val size = returnCursor.getLong(sizeIndex).toString()
            val file = File(context.filesDir, name)
            try {
                val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
                val outputStream = FileOutputStream(file)
                var read = 0
                val maxBufferSize = 1 * 1024 * 1024
                val bytesAvailable: Int = inputStream?.available() ?: 0
                //int bufferSize = 1024;
                val bufferSize = Math.min(bytesAvailable, maxBufferSize)
                val buffers = ByteArray(bufferSize)
                while (inputStream?.read(buffers).also {
                        if (it != null) {
                            read = it
                        }
                    } != -1) {
                    outputStream.write(buffers, 0, read)
                }
                inputStream?.close()
                outputStream.close()

            } catch (e: java.lang.Exception) {
//                AppLogger.e("Exception", e.message!!)
            }
            return file.path
        }


        fun isAppIsInBackground(context: Context): Boolean {
            var isInBackground = true
            val am = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            val runningProcesses = am.runningAppProcesses
            if (runningProcesses != null && runningProcesses.size > 0) {
                for (processInfo in runningProcesses) {
                    if (processInfo.importance == RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                        for (activeProcess in processInfo.pkgList) {
                            if (activeProcess == context.packageName) {
                                isInBackground = false
                            }
                        }
                    }
                }
            }
            return isInBackground
        }

        fun getDocumentMimeTypes(): Array<String> {
            // below array as per this index: doc, docx, xls, xlsx, pdf
            return arrayOf(
                "application/msword",
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
                "application/vnd.ms-excel",
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                "application/pdf"
            )
        }

        fun extractYTId(ytUrl: String?): String? {
            var vId: String? = null
            val pattern = Pattern.compile(
                "^https?://.*(?:youtu.be/|v/|u/\\w/|embed/|watch?v=)([^#&?]*).*$",
                Pattern.CASE_INSENSITIVE
            )
            val matcher = pattern.matcher(ytUrl)
            if (matcher.matches()) {
                vId = matcher.group(1)
            }
            return vId
        }

        fun spToPx(context: Context, sp: Float): Int {
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, sp, context.resources.displayMetrics
            ).toInt()
        }

        fun getHtmlText(mainString: String, forDisplay: Boolean = true): String {
            var finalString = ""
            return if (mainString.isNullOrEmpty()) {
                finalString
            } else {
                // android now supports start & end, instead of left & right. So need to replace while displaying but remains same for web
                finalString = if (forDisplay) {
                    mainString.replace("text-align: left", "text-align: start")
                        .replace("text-align: right", "text-align: end").trim()
                } else {
                    mainString.replace("text-align: start", "text-align: left")
                        .replace("text-align: end", "text-align: right").trim()
                }
                finalString.trim()
            }
        }

        // Firebase Analytics
        fun logScreenViewEvent(context: Context, module: String) {
            /*val bundle = Bundle()
            bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, module)
            FirebaseAnalytics.getInstance(context)
                .logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle)*/
        }

        /*fun addEventToCalendar(context: Context, eventDetail: EventDetailModel) {

            val beginDate = eventDetail.event_time.toDate()
            val endDate = eventDetail.event_end_time.toDate()

            val clickableAddress =
                SpannableString("${eventDetail.venue}, ${eventDetail.address.address}, ${eventDetail.address.city}, ${eventDetail.address.state}, ${eventDetail.address.country}, ${eventDetail.address.pin_code}")

            val intent = Intent(Intent.ACTION_INSERT).setData(Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginDate.time)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endDate.time)
                .putExtra(Events.TITLE, eventDetail.event_name)
                .putExtra(Events.DESCRIPTION, getHtmlText(eventDetail.desc))
                .putExtra(Events.AVAILABILITY, Events.AVAILABILITY_FREE)
                .putExtra(Events.HAS_ALARM, 1)
                .putExtra(Events.EVENT_LOCATION, clickableAddress.toString())
            context.startActivity(intent)

        }*/

        fun convertDpToPx(context: Context, dp: Int): Float {
            return dp * context.resources.displayMetrics.density
        }

        fun calculateAge(calendar: Calendar): Int {
            val today = Calendar.getInstance()
            var years = today.get(Calendar.YEAR) - calendar.get(Calendar.YEAR)
            val months = today.get(Calendar.MONTH) - calendar.get(Calendar.MONTH)
            val days = today.get(Calendar.DAY_OF_MONTH) - calendar.get(Calendar.DAY_OF_MONTH)

            // If the months and days are negative, then the age is one year less.
            if (months < 0 || (months == 0 && days < 0)) {
                years -= 1
            }

            return years
        }

    }

    interface OnDateSelection {
        fun onDateSelect(day: Int, month: Int, year: Int)
    }

    interface OnDateTimeSelection {
        fun onDateTimeSelect(pickedDateTime: Calendar)
    }

}