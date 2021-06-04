package com.instechrx.natemovie.ui.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.instechrx.natemovie.R
import com.instechrx.natemovie.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ig: String = getString(R.string.linkIg)
        val github: String = getString(R.string.linkGit)
        val facebook: String = getString(R.string.linkFb)

        binding.btnGithub.setOnClickListener {
            val uri: Uri =
                    Uri.parse(github)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        binding.btnIg.setOnClickListener {
            val uri: Uri =
                    Uri.parse(ig)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        binding.btnFb.setOnClickListener {
            val uri: Uri =
                    Uri.parse(facebook)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        Glide.with(this)
                .load(R.drawable.nabil)
                .apply(RequestOptions.circleCropTransform())
                .placeholder(R.drawable.ic_picture_empty)
                .into(binding.ivPicture)
    }

}