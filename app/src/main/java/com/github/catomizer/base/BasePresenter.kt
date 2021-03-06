package com.github.catomizer.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpPresenter
import moxy.MvpView

abstract class BasePresenter<V : MvpView>: MvpPresenter<V>() {

    private val disposables: CompositeDisposable = CompositeDisposable()

    protected fun Disposable.connect() = disposables.add(this)

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }
}