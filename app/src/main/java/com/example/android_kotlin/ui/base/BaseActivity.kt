
package com.example.android_kotlin.ui.base

import android.annotation.TargetApi
import android.app.ProgressDialog
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle

import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import butterknife.Unbinder
import com.example.android_kotlin.R


abstract class  BaseActivity : AppCompatActivity(), MvpView { //}, BaseFragment.Callback {

   // private val mProgressDialog: ProgressDialog? = null

    private var mUnBinder: Unbinder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun showLoading() {
        hideLoading()
        // mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    override fun hideLoading() {
       /* if (mProgressDialog != null && mProgressDialog.isShowing) {
            mProgressDialog.cancel()
        }*/
    }


    override fun onError(message: String) {

        // showSnackBar(getString(R.string.some_error));

    }

    override fun onError(@StringRes resId: Int) {
        onError(getString(resId))
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(@StringRes resId: Int) {
        showMessage(getString(resId))
    }


/*
    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }
*/

    override fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }


    fun setUnBinder(unBinder: Unbinder) {
        mUnBinder = unBinder
    }

    override fun onDestroy() {

        if (mUnBinder != null) {
            mUnBinder!!.unbind()
        }
        super.onDestroy()
    }

    protected abstract fun setUp()
}
