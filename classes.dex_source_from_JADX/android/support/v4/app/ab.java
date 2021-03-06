package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ad.C0053a;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* compiled from: NotificationCompatApi20 */
class ab {

    /* compiled from: NotificationCompatApi20 */
    public static class C0072a implements C0070y, C0071z {
        private Builder f231a;
        private Bundle f232b;

        public C0072a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2) {
            boolean z6;
            Builder lights = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
            if ((notification.flags & 2) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            lights = lights.setOngoing(z6);
            if ((notification.flags & 8) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            lights = lights.setOnlyAlertOnce(z6);
            if ((notification.flags & 16) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            lights = lights.setAutoCancel(z6).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            this.f231a = lights.setFullScreenIntent(pendingIntent2, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str).setGroupSummary(z5).setSortKey(str2);
            this.f232b = new Bundle();
            if (bundle != null) {
                this.f232b.putAll(bundle);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                this.f232b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
        }

        public void mo36a(C0053a c0053a) {
            ab.m258a(this.f231a, c0053a);
        }

        public Builder mo35a() {
            return this.f231a;
        }

        public Notification mo37b() {
            this.f231a.setExtras(this.f232b);
            return this.f231a.build();
        }
    }

    public static void m258a(Builder builder, C0053a c0053a) {
        Action.Builder builder2 = new Action.Builder(c0053a.mo29a(), c0053a.mo30b(), c0053a.mo31c());
        if (c0053a.mo33f() != null) {
            for (RemoteInput addRemoteInput : ak.m289a(c0053a.mo33f())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        if (c0053a.mo32d() != null) {
            builder2.addExtras(c0053a.mo32d());
        }
        builder.addAction(builder2.build());
    }
}
