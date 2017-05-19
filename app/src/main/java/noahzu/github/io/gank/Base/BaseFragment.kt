package noahzu.github.io.gank.Base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by zujinhao on 17/5/19.
 */
open abstract class BaseFragment : Fragment(){
    private lateinit var contentView : View

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        contentView = inflater!!.inflate(getLayout(),container,false)
        initView()
        initData()
        initListener()
        return contentView
    }

    abstract protected fun initView()
    abstract protected fun initData()
    abstract protected fun initListener()

    abstract protected fun getLayout(): Int

    protected fun getContentView() : View{
        return contentView
    }


}