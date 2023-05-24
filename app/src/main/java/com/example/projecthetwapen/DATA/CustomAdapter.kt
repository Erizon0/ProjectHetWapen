import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.projecthetwapen.DATA.Beer
import com.example.projecthetwapen.R
import java.io.BufferedInputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class CustomAdapter(private val context: Context, private val itemList: List<Beer>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView: View
        val holder: ViewHolder

        if (convertView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.beer_item, parent, false)
            holder = ViewHolder()
//            holder.imageView = itemView.findViewById(R.id.beerImage)
            holder.subtitleTextView = itemView.findViewById(R.id.item_subtitle)
            holder.extraSubtitleTextView = itemView.findViewById(R.id.item_extra_subtitle)
            itemView.tag = holder
        } else {
            itemView = convertView
            holder = convertView.tag as ViewHolder
        }

        val currentItem = itemList[position]
//        holder.imageView?.setImageResource(currentItem.image)
        holder.subtitleTextView?.text = currentItem.name
        holder.extraSubtitleTextView?.text = currentItem.description

        return itemView
    }

    override fun getItem(position: Int): Any {
        return itemList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return itemList.size
    }

    private class ViewHolder {
        var imageView: ImageView? = null
        var subtitleTextView: TextView? = null
        var extraSubtitleTextView: TextView? = null
    }

    private inner class LoadImageTask(private val imageView: ImageView) : AsyncTask<String, Void, Bitmap?>() {
        override fun doInBackground(vararg params: String): Bitmap? {
            val imageUrl = params[0]
            var connection: HttpURLConnection? = null
            var inputStream: BufferedInputStream? = null

            try {
                val url = URL(imageUrl)
                connection = url.openConnection() as HttpURLConnection
                connection.connect()

                inputStream = BufferedInputStream(connection.inputStream)
                return BitmapFactory.decodeStream(inputStream)
            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                connection?.disconnect()
                try {
                    inputStream?.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

            return null
        }
    }
}
