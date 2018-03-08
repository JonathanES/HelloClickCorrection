package fr.epita.helloclick
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener  {

    var reverse = false
    var incr = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_click.setOnClickListener(this@MainActivity)
        button_reset.setOnClickListener(this@MainActivity)
        button_big.setOnClickListener(this@MainActivity)
        button_normal.setOnClickListener(this@MainActivity)
        button_reverse.setOnClickListener(this@MainActivity)
    }

    override fun onClick(clickedView: View?) {
        if (clickedView != null) {
            when (clickedView.id) {
                R.id.button_reverse -> {
                    when (reverse){
                        true -> reverse = false
                        false -> reverse = true
                    }
                }
                R.id.button_click -> {
                    // Let us log something we can see in the logcat console
                    val showCountTextView = findViewById<TextView>(R.id.text_result)
                    // Get the value of the text view.
                    val countString = showCountTextView.text.toString()
                    // Convert value to a number and increment it
                    var count: Int = Integer.parseInt(countString)
                    when (reverse) {
                        true -> count -= incr
                        false -> count += incr
                    }
                    showCountTextView.text = count.toString();
                }
                R.id.button_reset -> {
                    val showCountTextView = findViewById<TextView>(R.id.text_result)
                    // Get the value of the text view.
                    val countString = showCountTextView.text.toString()
                    // Convert value to a number and increment it
                    var count: Int = Integer.parseInt(countString)
                    count = 0
                    showCountTextView.text = count.toString();
                }

                R.id.button_big -> {
                    incr++
                }
                R.id.button_normal -> {
                    incr = 1
                }
                else -> {
                    // In theory, you should never reach this line
                }
            }
        }
    }

}
