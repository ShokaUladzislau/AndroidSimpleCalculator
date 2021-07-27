package org.hyperskill.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var num: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText: EditText = findViewById(R.id.editText)
        setClearBtnEvent(R.id.clearButton, editText)
        setNumBtnEvent(findViewById(R.id.button9), editText)
        setNumBtnEvent(findViewById(R.id.button8), editText)
        setNumBtnEvent(findViewById(R.id.button7), editText)
        setNumBtnEvent(findViewById(R.id.button6), editText)
        setNumBtnEvent(findViewById(R.id.button5), editText)
        setNumBtnEvent(findViewById(R.id.button4), editText)
        setNumBtnEvent(findViewById(R.id.button3), editText)
        setNumBtnEvent(findViewById(R.id.button2), editText)
        setNumBtnEvent(findViewById(R.id.button1), editText)
        setZeroBtnEvent(findViewById(R.id.button0), editText)
        setDotBtnEvent(findViewById(R.id.dotButton), editText)
        val eqlBtn: Button = findViewById(R.id.equalButton)
        setSubtrBtnEvent(findViewById(R.id.subtractButton), eqlBtn, editText)
        setAddBtnEvent(findViewById(R.id.addButton), eqlBtn, editText)
        setMultpBtnEvent(findViewById(R.id.multiplyButton), eqlBtn, editText)
        setDivBtnEvent(findViewById(R.id.divideButton), eqlBtn, editText)
    }
    fun setZeroBtnEvent(
            btn: Button,
            linked: EditText
    ) {
        btn.setOnClickListener {
            linked.text.append(btn.text)
        }
    }
    fun setDotBtnEvent(
            btn: Button,
            linked: EditText
    ) {
        btn.setOnClickListener {
            // LOCK INPUT TYPE TO NONE
            linked.text.append(btn.text)
        }
    }
    fun setSubtrBtnEvent(
            btn: Button,
            eqlBtn: Button,
            linked: EditText
    ) {
        btn.setOnClickListener {
            // LOCK INPUT TYPE TO NONE
            if (linked.text.isNotEmpty()) {
                num = linked.text.toString().toDouble()
                linked.hint = linked.text
                linked.setText("")
            } else {
                linked.text.append(btn.text)
            }
            eqlBtn.setOnClickListener {
                val result = num - linked.text.toString().toDouble()
                if (result.toString().endsWith(".0")){
                    linked.setText(result.toInt().toString())
                    return@setOnClickListener
                } else {
                    linked.setText(result.toString())
                    return@setOnClickListener
                }
            }
        }
    }
    fun setAddBtnEvent(
            btn: Button,
            eqlBtn: Button,
            linked: EditText
    ) {
        btn.setOnClickListener {
            // LOCK INPUT TYPE TO NONE
            num = linked.text.toString().toDouble()
            linked.hint = linked.text
            linked.setText("")
            eqlBtn.setOnClickListener {
                val result = num + linked.text.toString().toDouble()
                if (result.toString().endsWith(".0")){
                    linked.setText(result.toInt().toString())
                    return@setOnClickListener
                } else {
                    linked.setText(result.toString())
                    return@setOnClickListener
                }
            }
        }
    }
    fun setMultpBtnEvent(
            btn: Button,
            eqlBtn: Button,
            linked: EditText
    ) {
        btn.setOnClickListener {
            // LOCK INPUT TYPE TO NONE
            num = linked.text.toString().toDouble()
            linked.hint = linked.text
            linked.setText("")
            eqlBtn.setOnClickListener {
                val result = num * linked.text.toString().toDouble()
                if (result.toString().endsWith(".0")){
                    linked.setText(result.toInt().toString())
                    return@setOnClickListener
                } else {
                    linked.setText(result.toString())
                    return@setOnClickListener
                }
            }
        }
    }
    fun setDivBtnEvent(
            btn: Button,
            eqlBtn: Button,
            linked: EditText
    ) {
        btn.setOnClickListener {
            // LOCK INPUT TYPE TO NONE
            num = linked.text.toString().toDouble()
            linked.hint = linked.text
            linked.setText("")
            eqlBtn.setOnClickListener {
                val result = num / linked.text.toString().toDouble()
                if (result.toString().endsWith(".0")){
                    linked.setText(result.toInt().toString())
                    return@setOnClickListener
                } else {
                    linked.setText(result.toString())
                    return@setOnClickListener
                }
            }
        }
    }
    fun setNumBtnEvent(
            btn: Button,
            linked: EditText
    ) = btn.setOnClickListener {
        linked.text.append(btn.text)
    }
    fun setClearBtnEvent(
            btnId: Int,
            linked: EditText
    ) = findViewById<Button>(btnId).setOnClickListener {
        linked.setText("")
    }
}