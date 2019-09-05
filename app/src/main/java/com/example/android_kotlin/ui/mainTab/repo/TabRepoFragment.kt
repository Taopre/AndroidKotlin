package com.example.android_kotlin.ui.mainTab.repo

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.android_kotlin.MainApplication

import com.example.android_kotlin.R
import com.example.android_kotlin.model.Repo
import com.example.android_kotlin.ui.adapter.OnClickRepository
import com.example.android_kotlin.ui.adapter.RepoListAdapter
import com.example.android_kotlin.ui.base.BaseFragment
import mu.KLogging
import javax.inject.Inject

class TabRepoFragment : BaseFragment() , TabRepoMvpView, OnClickRepository{

    @BindView(R.id.tabRepoRecyclerView)
    lateinit var tabRepoRecyclerView : RecyclerView

    @Inject lateinit var mPresenter: TabRepoPresenter<TabRepoMvpView>

    lateinit var mAdapter: RepoListAdapter
    lateinit var mLayoutManager: GridLayoutManager
    private val TAG ="tab_home_fragment"

    //private val logger = KotlinLogging.logger{}

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (activity?.application as MainApplication).component
            .inject(this)
        mPresenter.injectView(this)

    }

    //
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_repo, container, false)

        setUnBinder(ButterKnife.bind(this,view))
        mPresenter.onAttach(this)

 /*       mLayoutManager =  GridLayoutManager(context,2,RecyclerView.VERTICAL,false)

        tabRepoRecyclerView.layoutManager = mLayoutManager*/
        //mAdapter = RepoListAdapter(view.context)
        //tabRepoRecyclerView.adapter = mAdapter
        //mPresenter.loadData()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getRepoInfo()

        configurationRecyclerView()
    }

    override fun getRepoInfo() {
        user?.let { mPresenter.loadData(it) }
    }

    override fun configurationRecyclerView() {
        tabRepoRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
        }
    }



    override fun showRepo(repoList: List<Repo>) {
        mAdapter = RepoListAdapter(repoList,this)
        tabRepoRecyclerView.adapter = mAdapter
    }

    override fun onClickRepoItem(repo: Repo) {

        // 저장소 클릭 시 처리하는 부분
    }

    override fun onDestroy() {
       // mPresenter.onDestroy()
        super.onDestroy()
    }

    fun setUp(view: View) {
        Log.d(TAG, "현재 setUp")
    }

    private val user: String? get() = arguments?.getString(EXTRA_USER)

    companion object {
        private const val EXTRA_USER = "EXTRA_USER"

        fun newInstance(user: String): TabRepoFragment {
            val fragment = TabRepoFragment()
            Bundle().apply {
                putString(EXTRA_USER, user)
                fragment.arguments = this
            }
            return fragment
        }
    }



}
/*
class TabRepoFragment : Fragment() {

   // private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tab_home, container, false)

        return view
    }

    fun onButtonPressed(uri: Uri) {
      //  listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()
     //   listener = null
    }


    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    fun newInstance(): TabRepoFragment
    {
        val args = Bundle()

        val frag = TabRepoFragment()
        frag.arguments = args

        return frag
    }

}
*/
