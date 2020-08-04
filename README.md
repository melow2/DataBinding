# DataBinding

## How findeViewByID() works?
뷰에 대한 참조를 얻기위해 findViewById()를 사용할 때마다 안드로이드 시스템은 뷰계층을 거쳐
런타임에 그것을 찾아야한다. 더 큰 안드로이드 앱에서는 많은 레이아웃과 수백개의 뷰가 있을 수 있는데,
오늘 날 시장에 출시된 대부분의 안드로이드 폰은 적어도 60Hz의 리프레시 주파수를 가지고 있다.

그것은 화면은 초당 60회 또는 1000밀리초당 60회 새로 고쳐진다는 것인데,
1000을 60으로 나누면 이것은 안드로이드 시스템이 매 16밀리초마다 현재 화면을 재생성해야한다는 것을 의미한다.

즉 안드로이드 시스템은 16밀리초마다 다시 뷰 계층을 거쳐 런타임에 뷰를 찾아야 한다.
물론 일부 고급 안드로이드 폰은 리프레시 주파수가 90Hz~120Hz의 주파수를 갖고 있다.
그래서 안드로이드 시스템은 뷰를 재생성하는 시간이 훨씬 짧아지고 있다. 

하지만 런타임에 몇번이고 반복하는 것은 좋은 아이디어가 아니었다.그것은 더 큰 안드로이드 응용프로그램의 성능을 감소시키며,
이를 해결하기 위한 방법으로 데이터 바인딩을 제시한다. 


## How Databinding Works?
우리가 데이터 바인딩을 사용할 때, 우리는 레이아웃의 각 보기에 대한 참조를 포함하는 바인딩 객체를 만든다. 
바인딩 오브젝트가 생성되면, 앱의 모든 구성요소는 바인딩 오브젝트를 통해 보기 및 기타 데이터에 액세스할 수 있다.

이렇게 하면 안드로이드 시스템은 항상 보기를 검색하면서 보기 계층을 반복해서 거칠 필요가 없다.
그런 식으로 데이터 바인딩은 우리 앱의 성능을 많이 향상시킨다.그러나 데이터 바인딩의 이점은 그것뿐만이 아니다.
데이터 바인딩을 통해 findViewById를 제거할 수 있으며, 데이터 바인딩을 통해 코드가 간결하고 읽기 쉽고 유지 관리도 용이하다.

이 데이터 바인딩 오브젝트 생성은 컴파일 시간에 발생한다. 
따라서 오류가 있으면 컴파일 시간에 인식할 수 있다.보기 관련 오류는 없을 것이다.
이것이 데이터 바인딩을 사용해야하는 이유이다.


## How to Use?
1. build.gradle(app level)
아래 코드를 추가한다.
```
dataBinding{
    enabled = true 
}
```
#
2. <layout/> 태그로 xml 파일 전체를 wrap한다.
```
<layout>
    <androidx.constraintlayout.widget.ConstraintLayout
        ....
    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
```
#
3. 아래와 같은 코드로 접근한다.
```
class MainActivity : AppCompatActivity() {

    lateinit var mBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
    }
}
```