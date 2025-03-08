package com.example.zadanie2231_animator

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.zadanie2231_animator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            startRocketAnimation()
        }
    }


    private fun startRocketAnimation() {

        // Создание и запуск новой анимации ракеты с помощью ObjectAnimator

//        val anim = ObjectAnimator.ofFloat(binding.rocketView, View.TRANSLATION_Y, 0F, -1000F)
//        anim.duration = 1000
//
//          anim.addListener(object : AnimatorListenerAdapter() {
//            override fun onAnimationStart(animation: Animator) {
//                // Show Toast message when the animation starts
//                Toast.makeText(this@MainActivity, "Animation start", Toast.LENGTH_SHORT).show()
//                println("start")
//            }
//
//            override fun onAnimationEnd(animation: Animator) {
//                // Show Toast message when the animation ends
//                Toast.makeText(this@MainActivity, "Animation end", Toast.LENGTH_SHORT).show()
//                println("end")
//            }
//        })
//
//        anim.start()
//    }
//}

        // Запуск анимации ракеты из задания 22.2.1 с помощью ObjectAnimator и AnimatorListener.
        // Прямого способа запустить XML-анимацию через ObjectAnimator.ofFloat() не существует.
        // ObjectAnimator.ofFloat() предназначен для создания новых анимаций,
        // а не для запуска существующих XML-анимаций.

        // Load the AnimatorSet from XML
        // (загружаем анимацию
        val animator = AnimatorInflater.loadAnimator(this, R.animator.rocket_anim_3)

        // Set the target view for the animation
        // (устанавливаем binding.rocketView в качестве цели анимации.)
        animator.setTarget(binding.rocketView)

        // Add a listener to the animation
        // (добавляем слушатель в анимацию)
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                // Show Toast message when the animation starts
                // (показываем сообщение при старте анимации)
                Toast.makeText(this@MainActivity, "Animation start", Toast.LENGTH_SHORT).show()
                println("start")
            }

            override fun onAnimationEnd(animation: Animator) {

                // Возврат свойствам представления их первоначальных значений
                // (картинка ракеты возвращается в точку отсчета)
                binding.rocketView.translationX = 0f
                binding.rocketView.translationY = 0f
                binding.rocketView.rotation = 0f

                // Show Toast message when the animation ends
                // (показываем сообщение в конце анимации)
                Toast.makeText(this@MainActivity, "Animation end", Toast.LENGTH_SHORT).show()
                println("end")
            }
        })

        // Start the animation
        animator.start()
    }
}
