package com.prismsoft.androidhelpers

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.KodeinAware
import org.kodein.di.direct
import org.kodein.di.generic.instance

inline fun <reified VM : ViewModel, T> T.viewModelShared(): Lazy<VM> where T : KodeinAware, T : Fragment {
    return lazy { ViewModelProvider(activity!!, direct.instance()).get(VM::class.java) }
}

inline fun <reified VM : ViewModel, T> T.viewModelFragment(): Lazy<VM> where T : KodeinAware, T : Fragment {
    return lazy { ViewModelProvider(this, direct.instance()).get(VM::class.java) }
}