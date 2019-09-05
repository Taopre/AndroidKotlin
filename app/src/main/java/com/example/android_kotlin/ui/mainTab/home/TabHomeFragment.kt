package com.example.android_kotlin.ui.mainTab.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.android_kotlin.MainApplication

import com.example.android_kotlin.R
import com.example.android_kotlin.model.Pet
import com.example.android_kotlin.ui.adapter.PetListAdapter
import com.example.android_kotlin.ui.base.BaseFragment
import mu.KLogging
import javax.inject.Inject

class TabHomeFragment : BaseFragment() , TabHomeMvpView{

    @BindView(R.id.tabHomeRecyclerView)
    lateinit var tabHomeRecyclerView : RecyclerView

   // @Inject lateinit var mPresenter: TabHomePresenter<TabHomeMvpView>
    @Inject lateinit var mPresenter: TabHomePresenter<TabHomeMvpView>

    lateinit var mAdapter: PetListAdapter
    lateinit var mLayoutManager: GridLayoutManager
    private val TAG ="tab_home_fragment"

    //private val logger = KotlinLogging.logger{}

    // Main 액티비티에서 보낸 매개변수를 번들로 담는 부분
    // 아직은 받는 매개변수 없음
    fun newInstance(): TabHomeFragment
    {
        val args = Bundle()
        val frag = TabHomeFragment()
        frag.arguments = args
        return frag
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)


        (activity?.application as MainApplication).component
            .inject(this)
        mPresenter.injectView(this)

    }

    //
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_tab_home, container, false)

        setUnBinder(ButterKnife.bind(this,view))

       // mPresenter = TabHomePresenter()
        mPresenter.onAttach(this)

        //setUp(view)

        mLayoutManager =  GridLayoutManager(context,2,RecyclerView.VERTICAL,false)

        tabHomeRecyclerView.setHasFixedSize(true)
        tabHomeRecyclerView.layoutManager = mLayoutManager

        mAdapter = PetListAdapter(view.context)
        tabHomeRecyclerView.adapter = mAdapter

        mPresenter.loadData()

        return view
    }

    fun setUp(view: View) {
        Log.d(TAG, "현재 setUp")
        //val largePadding = resources.getDimensionPixelSize(R.dimen.shr_product_grid_spacing)
        //val smallPadding = resources.getDimensionPixelSize(R.dimen.shr_product_grid_spacing_small)
        //tabHomeRecyclerView.addItemDecoration(RecyclerView.ItemDecoration(largePadding, smallPadding))

    }

    override fun updatePetList(petList : ArrayList<Pet>) {
        Log.d(TAG, "현재 updatePetList ${petList.size}")

       // mAdapter = PetListAdapter(context!!,petList)

       // tabHomeRecyclerView.adapter = mAdapter

        mAdapter.addItemList(petList)
    }
    override fun onDestroy() {
       // mPresenter.onDestroy()
        super.onDestroy()
    }

    companion object: KLogging()
}
/*
class TabHomeFragment : Fragment() {

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

    fun newInstance(): TabHomeFragment
    {
        val args = Bundle()

        val frag = TabHomeFragment()
        frag.arguments = args

        return frag
    }

}
*/
