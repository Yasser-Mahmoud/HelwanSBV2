package com.google.android.youtube.player.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;

public final class n
  extends FrameLayout
{
  private final ProgressBar a;
  private final TextView b;
  
  public n(Context paramContext)
  {
    super(paramContext, null, z.c(paramContext));
    m localm = new m(paramContext);
    setBackgroundColor(-16777216);
    this.a = new ProgressBar(paramContext);
    this.a.setVisibility(8);
    addView(this.a, new FrameLayout.LayoutParams(-2, -2, 17));
    int i = (int)(10.0F * paramContext.getResources().getDisplayMetrics().density + 0.5F);
    this.b = new TextView(paramContext);
    this.b.setTextAppearance(paramContext, 16973894);
    this.b.setTextColor(-1);
    this.b.setVisibility(8);
    this.b.setPadding(i, i, i, i);
    this.b.setGravity(17);
    this.b.setText(localm.a);
    addView(this.b, new FrameLayout.LayoutParams(-2, -2, 17));
  }
  
  public final void a()
  {
    this.a.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  public final void b()
  {
    this.a.setVisibility(0);
    this.b.setVisibility(8);
  }
  
  public final void c()
  {
    this.a.setVisibility(8);
    this.b.setVisibility(0);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    if ((i == 1073741824) && (j == 1073741824))
    {
      i = k;
      j = m;
    }
    else if ((i == 1073741824) || ((i == -2147483648) && (j == 0)))
    {
      j = (int)((i = k) / 1.777F);
    }
    else if ((j == 1073741824) || ((j == -2147483648) && (i == 0)))
    {
      i = (int)((j = m) * 1.777F);
    }
    else if ((i == -2147483648) && (j == -2147483648))
    {
      if (m < k / 1.777F)
      {
        i = (int)(m * 1.777F);
        j = m;
      }
      else
      {
        j = (int)((i = k) / 1.777F);
      }
    }
    else
    {
      i = 0;
      j = 0;
    }
    i = resolveSize(i, paramInt1);
    j = resolveSize(j, paramInt2);
    paramInt1 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    paramInt2 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.internal.n
 * JD-Core Version:    0.7.0.1
 */