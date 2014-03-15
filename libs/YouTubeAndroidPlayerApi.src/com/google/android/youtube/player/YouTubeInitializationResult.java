package com.google.android.youtube.player;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Log;
import com.google.android.youtube.player.internal.ac;
import com.google.android.youtube.player.internal.m;
import com.google.android.youtube.player.internal.z;

public enum YouTubeInitializationResult
{
  private YouTubeInitializationResult() {}
  
  public final boolean isUserRecoverableError()
  {
    switch (1.a[ordinal()])
    {
    case 1: 
    case 2: 
    case 3: 
      return true;
    }
    return false;
  }
  
  public final Dialog getErrorDialog(Activity paramActivity, int paramInt)
  {
    return getErrorDialog(paramActivity, paramInt, null);
  }
  
  public final Dialog getErrorDialog(Activity paramActivity, int paramInt, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
    if (paramOnCancelListener != null) {
      localBuilder.setOnCancelListener(paramOnCancelListener);
    }
    Activity localActivity = paramActivity;
    paramOnCancelListener = this;
    switch (1.a[paramOnCancelListener.ordinal()])
    {
    case 1: 
    case 3: 
      tmpTernaryOp = z.b(z.a(localActivity));
      break;
    case 2: 
      tmpTernaryOp = z.a(z.a(localActivity));
      break;
    }
    paramOnCancelListener = null;
    paramInt = new a(paramActivity, paramOnCancelListener, paramInt);
    paramActivity = new m(paramActivity);
    switch (1.a[ordinal()])
    {
    case 1: 
      return localBuilder.setTitle(paramActivity.b).setMessage(paramActivity.c).setPositiveButton(paramActivity.d, paramInt).create();
    case 2: 
      return localBuilder.setTitle(paramActivity.e).setMessage(paramActivity.f).setPositiveButton(paramActivity.g, paramInt).create();
    case 3: 
      return localBuilder.setTitle(paramActivity.h).setMessage(paramActivity.i).setPositiveButton(paramActivity.j, paramInt).create();
    }
    throw new IllegalArgumentException("Unexpected errorReason: " + name());
  }
  
  private static final class a
    implements DialogInterface.OnClickListener
  {
    private final Activity a;
    private final Intent b;
    private final int c;
    
    public a(Activity paramActivity, Intent paramIntent, int paramInt)
    {
      this.a = ((Activity)ac.a(paramActivity, "activity cannot be null"));
      this.b = ((Intent)ac.a(paramIntent, "intent cannot be null"));
      this.c = ((Integer)ac.a(Integer.valueOf(paramInt), "requestCode cannot be null")).intValue();
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      try
      {
        this.a.startActivityForResult(this.b, this.c);
        paramDialogInterface.dismiss();
        return;
      }
      catch (ActivityNotFoundException paramDialogInterface)
      {
        paramInt = new Object[] { paramDialogInterface };
        paramDialogInterface = "Can't perform resolution for YouTubeInitalizationError";
        Log.e("YouTubeAndroidPlayerAPI", String.format(paramDialogInterface, paramInt));
      }
    }
  }
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.YouTubeInitializationResult
 * JD-Core Version:    0.7.0.1
 */