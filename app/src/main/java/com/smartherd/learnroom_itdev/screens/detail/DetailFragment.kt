package com.smartherd.learnroom_itdev.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.smartherd.learnroom_itdev.APP
import com.smartherd.learnroom_itdev.R
import com.smartherd.learnroom_itdev.databinding.FragmentDetailBinding
import com.smartherd.learnroom_itdev.databinding.FragmentStartBinding
import com.smartherd.learnroom_itdev.model.NoteModel
import com.smartherd.learnroom_itdev.screens.addNote.AddNoteViewModel

class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    lateinit var currentNote: NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentNote = arguments?.getSerializable("note") as NoteModel // получаем bundle
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        binding.btnDelete.setOnClickListener {
            viewModel.delete(currentNote) {}
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)

        }


        // вставляем в textView tvTitleDetail и tvDescDetail значения из bundle
        // которые мы взяли из БД
        binding.tvTitleDetail.text = currentNote.title
        binding.tvDescDetail.text = currentNote.description

        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }
    }

}