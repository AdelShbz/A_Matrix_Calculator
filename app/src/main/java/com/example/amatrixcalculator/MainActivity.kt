package com.example.amatrixcalculator

import android.content.Context

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.amatrixcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var row:Int = 3
    var col:Int = 3
    var editText = arrayOf(
        arrayOf("", "", "", ""),
        arrayOf("", "", "", ""),
        arrayOf("", "", "", ""),
        arrayOf("", "", "", "")
    )
    var matrixInt = arrayOf(
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.horizontalScrollView.visibility = View.INVISIBLE
        goneAllEditText()
        showUntilRow_Col(row,col)
    }

    fun setDefultVisibility() {
        binding.horizontalScrollView.visibility = View.VISIBLE
        binding.imageViewResultL.visibility = View.VISIBLE
        binding.imageViewResultR.visibility = View.VISIBLE
        binding.linearLayoutResult1.visibility = View.VISIBLE
        binding.linearLayoutResult2.visibility = View.VISIBLE
        binding.linearLayoutResult3.visibility = View.VISIBLE
        binding.linearLayoutResult4.visibility = View.VISIBLE
        binding.textViewEqual2.visibility = View.VISIBLE
        binding.imageViewResultInverseL.visibility = View.VISIBLE
        binding.imageViewResultInverseR.visibility = View.VISIBLE
        binding.linearLayoutResultInv1.visibility = View.VISIBLE
        binding.linearLayoutResultInv2.visibility = View.VISIBLE
        binding.linearLayoutResultInv3.visibility = View.VISIBLE
        binding.linearLayoutResultInv4.visibility = View.VISIBLE
        binding.textViewNumberResult.visibility = View.VISIBLE
    }
    fun hideKeyboard(view: View){
        val imm: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
    fun goneAllTextViews(){
        for (i: Int in 0 until 4) {
            for (j: Int in 0 until 4) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textView${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).visibility = View.GONE
            }
        }
    }
    fun goneAllTextViewResults(){
        for (i: Int in 0 until 4) {
            for (j: Int in 0 until 4) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textViewResult${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).visibility = View.GONE
            }
        }
    }
    fun goneAllTextViewResultInverses(){
        for (i: Int in 0 until 4) {
            for (j: Int in 0 until 4) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textViewResultInverse${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).visibility = View.GONE
            }
        }
    }
    fun visibleTextViewResultInverses(Row: Int, Col: Int){
        goneAllTextViewResultInverses()
        for (i: Int in 0 until Row) {
            for (j: Int in 0 until Col) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textViewResultInverse${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).visibility = View.VISIBLE
            }
        }
    }
    fun visibleTextViewResults(Row:Int, Col:Int){
        goneAllTextViewResults()
        for (i: Int in 0 until Row) {
            for (j: Int in 0 until Col) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textViewResult${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).visibility = View.VISIBLE
            }
        }
    }
    fun visibleTextViews(Row:Int, Col:Int){
        goneAllTextViews()
        for (i: Int in 0 until Row) {
            for (j: Int in 0 until Col) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textView${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).visibility = View.VISIBLE
            }
        }
    }
    fun onRank(view: View) {
        getNumbers()
        var temp = 0
        for (i: Int in 0 until row) {
            for (j: Int in 0 until col) {
                if (editText[i][j] == "") {
                    ++temp
                }
            }
        }
        if (temp != 0) {
            Toast.makeText(this@MainActivity, "همه درایه ها را پر کنید.", Toast.LENGTH_LONG).show()
            return
        }
        hideKeyboard(view)
        assignmentIntMatrix()
        visibleTextViews(row, col)
        for (i: Int in 0 until row) {
            for (j: Int in 0 until col) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textView${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = matrixInt[i][j].toString()
            }
        }
        setDefultVisibility()
        binding.textViewOperation.text = "Rank"
        binding.imageViewResultL.visibility = View.GONE
        binding.imageViewResultR.visibility = View.GONE
        binding.linearLayoutResult1.visibility = View.GONE
        binding.linearLayoutResult2.visibility = View.GONE
        binding.linearLayoutResult3.visibility = View.GONE
        binding.linearLayoutResult4.visibility = View.GONE
        binding.textViewEqual2.visibility = View.GONE
        binding.imageViewResultInverseL.visibility = View.GONE
        binding.imageViewResultInverseR.visibility = View.GONE
        binding.linearLayoutResultInv1.visibility = View.GONE
        binding.linearLayoutResultInv2.visibility = View.GONE
        binding.linearLayoutResultInv3.visibility = View.GONE
        binding.linearLayoutResultInv4.visibility = View.GONE
        binding.textViewNumberResult.text = Rank.rankOfMatrix(matrixInt, 4, 4).toString()
        setDefult()
    }

    fun onDet(view: View) {
        getNumbers()
        var temp = 0
        for (i: Int in 0 until row) {
            for (j: Int in 0 until col) {
                if (editText[i][j] == "") {
                    ++temp
                }
            }
        }
        if (temp != 0) {
            Toast.makeText(this@MainActivity, "همه درایه ها را پر کنید.", Toast.LENGTH_LONG).show()
            return
        }
        if (row != col){
            Toast.makeText(this,"ماتریس مربعی نیست.", Toast.LENGTH_SHORT).show()
            return
        }
        hideKeyboard(view)
        assignmentIntMatrix()
        visibleTextViews(row, col)
        for (i: Int in 0 until row) {
            for (j: Int in 0 until col) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textView${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = matrixInt[i][j].toString()
            }
        }
        val finalMatrix = Array(row) { IntArray(col) }
        for (i: Int in 0 until row) {
            for (j: Int in 0 until col) {
                finalMatrix[i][j] = matrixInt[i][j]
            }
        }
        setDefultVisibility()
        binding.textViewOperation.text = "Det"
        binding.imageViewResultL.visibility = View.GONE
        binding.imageViewResultR.visibility = View.GONE
        binding.linearLayoutResult1.visibility = View.GONE
        binding.linearLayoutResult2.visibility = View.GONE
        binding.linearLayoutResult3.visibility = View.GONE
        binding.linearLayoutResult4.visibility = View.GONE
        binding.textViewEqual2.visibility = View.GONE
        binding.imageViewResultInverseL.visibility = View.GONE
        binding.imageViewResultInverseR.visibility = View.GONE
        binding.linearLayoutResultInv1.visibility = View.GONE
        binding.linearLayoutResultInv2.visibility = View.GONE
        binding.linearLayoutResultInv3.visibility = View.GONE
        binding.linearLayoutResultInv4.visibility = View.GONE
        binding.textViewNumberResult.text = Determinant.determinantOfMatrix(finalMatrix, row).toString()
        setDefult()
    }

    fun onInverse(view: View) {
        getNumbers()
        var temp = 0
        for (i: Int in 0 until row) {
            for (j: Int in 0 until col) {
                if (editText[i][j] == "") {
                    ++temp
                }
            }
        }
        if (temp != 0) {
            Toast.makeText(this@MainActivity, "همه درایه هارا پر کنید.", Toast.LENGTH_LONG).show()
            return
        }
        if (row != col){
            Toast.makeText(this,"ماتریس مربعی نیست.", Toast.LENGTH_SHORT).show()
            return
        }
        hideKeyboard(view)
        assignmentIntMatrix()
        visibleTextViews(row, col)
        for (i: Int in 0 until row) {
            for (j: Int in 0 until col) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textView${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = matrixInt[i][j].toString()
            }
        }
        if (Determinant.determinantOfMatrix(matrixInt, row) == 0) {
            setDefultVisibility()
            binding.textViewNumberResult.text = " there is no inverse."
            binding.textViewOperation.text = "Inverse"
            binding.imageViewResultL.visibility = View.GONE
            binding.imageViewResultR.visibility = View.GONE
            binding.linearLayoutResult1.visibility = View.GONE
            binding.linearLayoutResult2.visibility = View.GONE
            binding.linearLayoutResult3.visibility = View.GONE
            binding.linearLayoutResult4.visibility = View.GONE
            binding.textViewEqual2.visibility = View.GONE
            binding.imageViewResultInverseL.visibility = View.GONE
            binding.imageViewResultInverseR.visibility = View.GONE
            binding.linearLayoutResultInv1.visibility = View.GONE
            binding.linearLayoutResultInv2.visibility = View.GONE
            binding.linearLayoutResultInv3.visibility = View.GONE
            binding.linearLayoutResultInv4.visibility = View.GONE
            setDefult()
            return
        }
        setDefult()
        getNumbers()
        assignmentIntMatrix()
        setDefultVisibility()
        binding.textViewOperation.text = "Inverse"
        binding.textViewNumberResult.visibility = View.GONE
        var inverseMatrixInString = Inverse.inverseOfMatrixInString(matrixInt, row)
        setDefult()
        getNumbers()
        assignmentIntMatrix()
        var inverseMatrixInFloat = Inverse.inverseOfMatrixInFloat(matrixInt, row)
        visibleTextViewResults(row, col)
        for (i: Int in 0 until row) {
            for (j: Int in 0 until col) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textViewResult${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = inverseMatrixInString[i][j]
            }
        }
        visibleTextViewResultInverses(row, col)
        for (i: Int in 0 until row) {
            for (j: Int in 0 until col) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textViewResultInverse${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = inverseMatrixInFloat[i][j].toString()
            }
        }
        setDefult()
    }

    fun onTranspose(view: View) {
        getNumbers()
        var temp = 0
        for (i: Int in 0 until row) {
            for (j: Int in 0 until col) {
                if (editText[i][j] == "") {
                    ++temp
                }
            }
        }
        if (temp != 0) {
            Toast.makeText(this@MainActivity, "همه درایه هارا پر کنید.", Toast.LENGTH_LONG).show()
            return
        }
        hideKeyboard(view)
        assignmentIntMatrix()
        visibleTextViews(row, col)
        for (i: Int in 0 until row) {
            for (j: Int in 0 until col) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textView${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = matrixInt[i][j].toString()
            }
        }
        setDefultVisibility()
        binding.textViewOperation.text = "T"
        binding.textViewEqual2.visibility = View.GONE
        binding.imageViewResultInverseL.visibility = View.GONE
        binding.imageViewResultInverseR.visibility = View.GONE
        binding.linearLayoutResultInv1.visibility = View.GONE
        binding.linearLayoutResultInv2.visibility = View.GONE
        binding.linearLayoutResultInv3.visibility = View.GONE
        binding.linearLayoutResultInv4.visibility = View.GONE
        binding.textViewNumberResult.visibility = View.GONE
        var Tmatrix = Transpose.transposeOfMatrix(matrixInt, row, col)
        visibleTextViewResults(col, row)
        for (i: Int in 0 until col) {
            for (j: Int in 0 until row) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textViewResult${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = Tmatrix[i][j].toString()
            }
        }
        setDefult()
    }

    fun onCofactor(view: View) {
        getNumbers()
        var temp = 0
        for (i: Int in 0 until row) {
            for (j: Int in 0 until col) {
                if (editText[i][j] == "") {
                    ++temp
                }
            }
        }
        if (temp != 0) {
            Toast.makeText(this@MainActivity, "همه درایه هارا پر کنید.", Toast.LENGTH_LONG).show()
            return
        }
        if (row != col){
            Toast.makeText(this,"ماتریس مربعی نیست.", Toast.LENGTH_SHORT).show()
            return
        }
        hideKeyboard(view)
        assignmentIntMatrix()
        visibleTextViews(row, col)
        for (i: Int in 0 until row) {
            for (j: Int in 0 until col) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textView${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = matrixInt[i][j].toString()
            }
        }
        setDefultVisibility()
        binding.textViewOperation.text = "Cofactor"
        binding.textViewEqual2.visibility = View.GONE
        binding.imageViewResultInverseL.visibility = View.GONE
        binding.imageViewResultInverseR.visibility = View.GONE
        binding.linearLayoutResultInv1.visibility = View.GONE
        binding.linearLayoutResultInv2.visibility = View.GONE
        binding.linearLayoutResultInv3.visibility = View.GONE
        binding.linearLayoutResultInv4.visibility = View.GONE
        binding.textViewNumberResult.visibility = View.GONE
        var CofMatrix = Cofactor.cofactorOfMatrix(matrixInt, row)
        visibleTextViewResults(row, col)
        for (i: Int in 0 until row) {
            for (j: Int in 0 until col) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textViewResult${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = CofMatrix[i][j].toString()
            }
        }
        setDefult()
    }

    fun onAdjoint(view: View) {
        getNumbers()
        var temp = 0
        for (i: Int in 0 until row) {
            for (j: Int in 0 until col) {
                if (editText[i][j] == "") {
                    ++temp
                }
            }
        }
        if (temp != 0) {
            Toast.makeText(this@MainActivity, "همه درایه هارا پر کنید.", Toast.LENGTH_LONG).show()
            return
        }
        if (row != col){
            Toast.makeText(this,"ماتریس مربعی نیست.", Toast.LENGTH_SHORT).show()
            return
        }
        hideKeyboard(view)
        assignmentIntMatrix()
        visibleTextViews(row, col)
        for (i: Int in 0 until row) {
            for (j: Int in 0 until col) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textView${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = matrixInt[i][j].toString()
            }
        }
        setDefultVisibility()
        binding.textViewOperation.text = "Adj"
        binding.textViewEqual2.visibility = View.GONE
        binding.imageViewResultInverseL.visibility = View.GONE
        binding.imageViewResultInverseR.visibility = View.GONE
        binding.linearLayoutResultInv1.visibility = View.GONE
        binding.linearLayoutResultInv2.visibility = View.GONE
        binding.linearLayoutResultInv3.visibility = View.GONE
        binding.linearLayoutResultInv4.visibility = View.GONE
        binding.textViewNumberResult.visibility = View.GONE
        var AdjMatrix = Adjoint.adjointOfMatrix(matrixInt, row)
        visibleTextViewResults(row, col)
        for (i: Int in 0 until row) {
            for (j: Int in 0 until col) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textViewResult${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = AdjMatrix[i][j].toString()
            }
        }
        setDefult()
    }

    fun getNumbers() {
        for (i: Int in 0 until row) {
            for (j: Int in 0 until col) {
                val resourceId =
                    this.resources.getIdentifier(
                        "editTextNumberSigned${i}${j}",
                        "id",
                        this.packageName
                    )
                editText[i][j] = findViewById<EditText>(resourceId).text.toString()
            }
        }

    }

    fun assignmentIntMatrix() {
        for (i: Int in 0 until row) {
            for (j: Int in 0 until col) {
                matrixInt[i][j] = editText[i][j].toInt()
            }
        }
    }

    fun setDefult() {
        for (i: Int in 0 until 4) {
            for (j: Int in 0 until 4) {
                editText[i][j] = ""
                matrixInt[i][j] = 0
            }
        }
    }

    fun goneAllEditText(){
        for (i: Int in 0 until 4){
            for (j: Int in 0 until 4){
                val resourceId =
                    this.resources.getIdentifier(
                        "editTextNumberSigned${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<EditText>(resourceId).visibility = View.GONE
            }
        }
    }

    fun showUntilRow_Col(Row:Int, Col:Int){
        for (i: Int in 0 until Row){
            for (j: Int in 0 until Col){
                val resourceId =
                    this.resources.getIdentifier(
                        "editTextNumberSigned${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<EditText>(resourceId).visibility = View.VISIBLE
            }
        }
    }
    fun addRow(view: View){
        if (row >= 4){
            Toast.makeText(this,"نهایت ابعاد 4*4 می باشد.", Toast.LENGTH_SHORT).show()
            return
        }
        for (i: Int in 0 until col){
            val resourceId =
                this.resources.getIdentifier(
                    "editTextNumberSigned${row}${i}",
                    "id",
                    this.packageName
                )
            findViewById<EditText>(resourceId).setText("")
        }
        goneAllEditText()
        row++
        showUntilRow_Col(row,col)
    }
    fun removeRow(view: View){
        if (row <= 1){
            Toast.makeText(this,"حداقل ابعاد 1*1 می باشد.", Toast.LENGTH_SHORT).show()
            return
        }
        goneAllEditText()
        row--
        showUntilRow_Col(row,col)
    }
    fun addCol(view: View){
        if (col >= 4){
            Toast.makeText(this,"نهایت ابعاد 4*4 می باشد.", Toast.LENGTH_SHORT).show()
            return
        }
        for (i: Int in 0 until row){
            val resourceId =
                this.resources.getIdentifier(
                    "editTextNumberSigned${i}${col}",
                    "id",
                    this.packageName
                )
            findViewById<EditText>(resourceId).setText("")
        }
        goneAllEditText()
        col++
        showUntilRow_Col(row,col)
    }
    fun removeCol(view: View){
        if (col <= 1){
            Toast.makeText(this,"حداقل ابعاد 1*1 می باشد.", Toast.LENGTH_SHORT).show()
            return
        }
        goneAllEditText()
        col--
        showUntilRow_Col(row,col)
    }
}