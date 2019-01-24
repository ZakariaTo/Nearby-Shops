import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS }    from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ShopCardComponent } from './shop-card/shop-card.component';
import { ShopsComponent } from './shops/shops.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AuthService } from './services/auth.service';
import { DataService } from './services/data.service';
import { JwtModule } from '@auth0/angular-jwt';
import { SignupComponent } from './signup/signup.component';
import { RouterModule } from '@angular/router';
import { NavbarComponent } from './navbar/navbar.component';
import { PrefshopsComponent } from './prefshops/prefshops.component';
import { AuthGuardService } from './services/auth-guard.service';
import { SigninGuard } from './services/signin-guard.service';
import { RequestInterceptor } from './services/request-interceptor.service';

export function tokenGetter() {
  return localStorage.getItem('access_token');
}

@NgModule({
  declarations: [
    AppComponent,
    ShopCardComponent,
    ShopsComponent,
    LoginComponent,
    SignupComponent,
    NavbarComponent,
    PrefshopsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    // JwtModule.forRoot({
    //   config: {
    //     tokenGetter: tokenGetter,
    //     whitelistedDomains: ['localhost:8080'],
    //     blacklistedRoutes: ['example.com/examplebadroute/']
    //   }
    // }),
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      { path: '', component: LoginComponent, canActivate: [SigninGuard] },
      { path: 'listShops', component: ShopsComponent, canActivate: [AuthGuardService]},
      { path:'preferredShop',component:PrefshopsComponent, canActivate: [AuthGuardService]},
      { path: 'signup', component: SignupComponent},
      { path: 'signin', component: LoginComponent, canActivate: [SigninGuard]},
    ])
  ],
  providers: [
    AuthService,
    DataService,
    SigninGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: RequestInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
