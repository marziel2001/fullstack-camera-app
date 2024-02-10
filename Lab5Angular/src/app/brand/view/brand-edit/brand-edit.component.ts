import {Component, OnInit} from '@angular/core';
import {BrandForm} from "../../model/brand-form";
import {BrandService} from "../../service/brand.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-brand-edit',
  templateUrl: './brand-edit.component.html',
  styleUrls: ['./brand-edit.component.css', '../../../forms.css']
})
export class BrandEditComponent implements OnInit {

    uuid: string | undefined;

    brand: BrandForm | undefined;

    original: BrandForm | undefined;

    constructor(
        private brandService: BrandService,
        private route: ActivatedRoute,
        private router: Router
    ) {
    }

    ngOnInit(): void {
        this.route.params.subscribe(params => {
            this.brandService.getBrand(params['uuid'])
                .subscribe(brand => {
                    this.uuid = params['uuid']
                    this.brand = {
                        // id: params['uuid'],
                        name: brand.name,
                        yearOfEst: brand.yearOfEst,
                        country: brand.country,
                        brandValueDollars: brand.brandValueDollars
                    };
                    this.original = {...this.brand};
                });
        });
    }

    onSubmit(): void {
        this.brandService.patchBrand(this.uuid!, this.brand!)
            .subscribe(() => this.router.navigate(['/brands']));
    }

}
