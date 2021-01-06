package com.br.julianovincedecampos.memorynotes.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.br.julianovincedecampos.memorynotes.R
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addNote.setOnClickListener { goToNoteDetails(0) }
    }

    private fun goToNoteDetails(id: Long) {
        val action = ListFragmentDirections.actionGoToNote(id)
        Navigation.findNavController(notesListView).navigate(action)
    }

}