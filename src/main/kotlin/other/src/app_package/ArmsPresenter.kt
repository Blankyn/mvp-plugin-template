package other.src.app_package

import other.ArmsPluginTemplateProviderImpl
import other.armsAnnotation

fun armsPresenter(isKt: Boolean, provider: ArmsPluginTemplateProviderImpl): String = if (isKt) armsPresenterKt(provider) else armsPresenterJava(provider)

private fun armsPresenterKt(provider: ArmsPluginTemplateProviderImpl) = """
package ${provider.presenterPackageName.value}
import android.app.Application
${
    if (provider.needActivity.value && provider.needFragment.value)
        "import com.blankm.arms.di.scope.ActivityScope"
    else if (provider.needActivity.value)
        "import com.blankm.arms.di.scope.ActivityScope"
    else if (provider.needFragment.value)
        "import com.blankm.arms.di.scope.FragmentScope"
    else ""
}
import com.blankm.arms.mvp.BasePresenter
import me.blankm.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject
import ${provider.contractPackageName.value}.${provider.pageName.value}Contract

$armsAnnotation
${
    if (provider.needActivity.value && provider.needFragment.value)
        "@ActivityScope"
    else if (provider.needActivity.value)
        "@ActivityScope"
    else if (provider.needFragment.value)
        "@FragmentScope"
    else ""
}
class ${provider.pageName.value}Presenter
@Inject
constructor(model: ${provider.pageName.value}Contract.Model, rootView: ${provider.pageName.value}Contract.View) :
BasePresenter<${provider.pageName.value}Contract.Model, ${provider.pageName.value}Contract.View>(model,rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler
    @Inject
    lateinit var mApplication: Application
    
    override fun onDestroy() {
          super.onDestroy()
    }
}   
"""


fun armsPresenterJava(provider: ArmsPluginTemplateProviderImpl) = """
package ${provider.presenterPackageName.value};
import android.app.Application;
${
    if (provider.needActivity.value && provider.needFragment.value)
        "import com.blankm.arms.di.scope.ActivityScope;"
    else if (provider.needActivity.value)
        "import com.blankm.arms.di.scope.ActivityScope;"
    else if (provider.needFragment.value)
        "import com.blankm.arms.di.scope.FragmentScope;"
    else ""
}
import com.blankm.arms.mvp.BasePresenter;
import me.blankm.rxerrorhandler.core.RxErrorHandler;
import javax.inject.Inject;
import ${provider.contractPackageName.value}.${provider.pageName.value}Contract;

$armsAnnotation
${
    if (provider.needActivity.value && provider.needFragment.value)
        "@ActivityScope"
    else if (provider.needActivity.value)
        "@ActivityScope"
    else if (provider.needFragment.value)
        "@FragmentScope"
    else ""
}
public class ${provider.pageName.value}Presenter extends BasePresenter<${provider.pageName.value}Contract.Model, ${provider.pageName.value}Contract.View>{
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
  
    
    @Inject
    public ${provider.pageName.value}Presenter (${provider.pageName.value}Contract.Model model, ${provider.pageName.value}Contract.View rootView) {
        super(model, rootView);
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mApplication = null;
    }
}   
"""